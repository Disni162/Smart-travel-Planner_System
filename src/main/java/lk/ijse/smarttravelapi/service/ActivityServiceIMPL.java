package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.ActivityDTO;
import lk.ijse.smarttravelapi.entity.Activity;
import lk.ijse.smarttravelapi.entity.Destination;
import lk.ijse.smarttravelapi.repository.ActivityRepository;
import lk.ijse.smarttravelapi.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceIMPL implements ActivityService {

    private final ActivityRepository activityRepository;
    private final DestinationRepository destinationRepository;

    @Override
    public ActivityDTO saveActivity(ActivityDTO dto) {
        Destination dest = destinationRepository.findById(dto.getDestinationId())
                .orElseThrow(() -> new RuntimeException("Destination not found"));

        Activity activity = Activity.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .image(dto.getImage())
                .destination(dest)
                .price(dto.getPrice())
                .duration(dto.getDuration())
                .type(dto.getType())
                .build();

        activity = activityRepository.save(activity);
        dto.setId(activity.getId());
        return dto;
    }

    @Override
    public ActivityDTO updateActivity(ActivityDTO dto) {
        Activity activity = activityRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        // Destination update wenn
        Destination dest = destinationRepository.findById(dto.getDestinationId())
                .orElseThrow(() -> new RuntimeException("Destination not found"));

        activity.setName(dto.getName());
        activity.setDescription(dto.getDescription());
        activity.setImage(dto.getImage());
        activity.setPrice(dto.getPrice());
        activity.setDuration(dto.getDuration());
        activity.setType(dto.getType());
        activity.setDestination(dest);

        activityRepository.save(activity);
        return mapToDTO(activity);
    }

    @Override
    public void deleteActivity(Long id) {
        if (!activityRepository.existsById(id)) {
            throw new RuntimeException("Activity not found");
        }
        activityRepository.deleteById(id);
    }

    @Override
    public ActivityDTO getActivity(Long id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
        return mapToDTO(activity);
    }

    @Override
    public List<ActivityDTO> getAllActivities() {
        return activityRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActivityDTO> getActivitiesByDestination(Long destinationId) {
        return activityRepository.findByDestinationId(destinationId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ActivityDTO mapToDTO(Activity activity) {
        return ActivityDTO.builder()
                .id(activity.getId())
                .name(activity.getName())
                .image(activity.getImage())
                .description(activity.getDescription())
                .destinationId(activity.getDestination().getId())
                .price(activity.getPrice())
                .duration(activity.getDuration())
                .type(activity.getType())
                .build();
    }
}
