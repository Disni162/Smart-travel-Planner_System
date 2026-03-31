package lk.ijse.smarttravelapi.controller;

import jakarta.validation.Valid;
import lk.ijse.smarttravelapi.dto.ActivityDTO;
import lk.ijse.smarttravelapi.entity.Activity;
import lk.ijse.smarttravelapi.entity.Destination;
import lk.ijse.smarttravelapi.repository.ActivityRepository;
import lk.ijse.smarttravelapi.repository.DestinationRepository;
import lk.ijse.smarttravelapi.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/activities")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ActivityController {

    private final ActivityService activityService;
    private final DestinationRepository destinationRepository;
    private  final ActivityRepository activityRepository;

    @PostMapping

    public ResponseEntity<?> createActivity(@Valid @RequestBody ActivityDTO dto) {
        try {
            // dto eke anawasha data thiyed kiyl check krnw
            if (dto.getDestinationId() == null) {
                return ResponseEntity.badRequest().body("Error: Destination ID is missing!");
            }

            Activity activity = new Activity();
            activity.setName(dto.getName());
            activity.setType(dto.getType());
            activity.setPrice(dto.getPrice());
            activity.setDuration(dto.getDuration());
            activity.setImage(dto.getImage());
            activity.setDescription(dto.getDescription());

            // find destination
            Destination destination = destinationRepository.findById(dto.getDestinationId())
                    .orElseThrow(() -> new RuntimeException("Destination not found"));

            activity.setDestination(destination);


            Activity savedActivity = activityRepository.save(activity);
            return ResponseEntity.ok(savedActivity);

        } catch (Exception e) {
            e.printStackTrace(); // error check krnn
            return ResponseEntity.status(500).body("Server Error: " + e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<ActivityDTO> updateActivity(@PathVariable Long id, @RequestBody ActivityDTO dto){

        dto.setId(id);
        return ResponseEntity.ok(activityService.updateActivity(dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id){
        activityService.deleteActivity(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity<List<ActivityDTO>> getAllActivities(){
        return ResponseEntity.ok(activityService.getAllActivities());
    }


    @GetMapping("/destination/{destinationId}")
    public ResponseEntity<List<ActivityDTO>> getActivitiesByDestination(@PathVariable Long destinationId){
        return ResponseEntity.ok(activityService.getActivitiesByDestination(destinationId));
    }
}