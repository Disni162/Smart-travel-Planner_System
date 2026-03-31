package lk.ijse.smarttravelapi.service;

import lk.ijse.smarttravelapi.dto.ActivityDTO;

import java.util.List;

public interface ActivityService {
    ActivityDTO saveActivity(ActivityDTO activityDTO);
    ActivityDTO updateActivity(ActivityDTO activityDTO);
    void deleteActivity(Long id);
    ActivityDTO getActivity(Long id);
    List<ActivityDTO> getAllActivities();
    List<ActivityDTO> getActivitiesByDestination(Long destinationId);
}
