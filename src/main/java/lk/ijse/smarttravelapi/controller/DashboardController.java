package lk.ijse.smarttravelapi.controller;

import lk.ijse.smarttravelapi.dto.DashboardDTO;
import lk.ijse.smarttravelapi.dto.DashboardResponseDTO;
import lk.ijse.smarttravelapi.dto.TrendingDestinationDTO;
import lk.ijse.smarttravelapi.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dashboard")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class DashboardController {

    // Service eka Inject krnwa
    private final DashboardService dashboardService;

    @GetMapping("/stats")
    public ResponseEntity<DashboardResponseDTO> getDashboardStats() {

        return ResponseEntity.ok(dashboardService.getDashboardStats());
    }
}