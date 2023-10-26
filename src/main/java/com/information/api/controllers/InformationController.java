package com.information.api.controllers;

import com.information.api.configs.InformationStatus;
import com.information.api.configs.InformationType;
import com.information.api.dto.InformationFilterDto;
import com.information.api.models.Information;
import com.information.api.service.InformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
//@CrossOrigin(origins = "http://localhost:3030/information", maxAge = 3600)
@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*", value = "*")
public class InformationController {

    private final InformationService informationService;

    @Autowired
    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("information")
    public ResponseEntity<?> getInformation() {
        return ResponseEntity.ok(informationService.getAllInformation());
    }

    @PostMapping("information")
    public ResponseEntity<?> createInformation(@RequestBody Information information) {

        informationService.createInformation(information);
        return ResponseEntity.ok("created successfully");
    }

    @GetMapping("information/filter")
    public ResponseEntity<?> getInformationByFilter(
            @RequestParam(value = "types", defaultValue = "", required = false) String types,
            @RequestParam(value = "fromTime") Optional<Long> fromTime,
            @RequestParam(value = "toTime") Optional<Long> toTime,
            @RequestParam(required = false, defaultValue = "", value = "status") String status
    ) {
        List<InformationType> informationTypes = new ArrayList<>();
        Arrays.stream(types.split(",")).toList().forEach(type -> {
            if (!Objects.equals(type, ""))
                informationTypes.add(InformationType.valueOf(type));
        });
        List<InformationStatus> informationStatuses = new ArrayList<>();
        Arrays.stream(status.split(",")).toList().forEach(currentStatus -> {
            if (!Objects.equals(currentStatus, ""))
                informationStatuses.add(InformationStatus.valueOf(currentStatus));
        });
        InformationFilterDto informationFilterDto =
                InformationFilterDto.builder().from(fromTime.orElse(0L)).types(informationTypes).to(toTime.orElse(0L)).status(informationStatuses).build();
        log.info(informationFilterDto.toString());
//        return ResponseEntity.ok("OK");
        return ResponseEntity.ok(informationService.getInformationByParams(
                informationFilterDto.getStatus(),
                informationFilterDto.getTypes(),
                informationFilterDto.getFrom(),
                informationFilterDto.getTo()
        ));
    }

    @PutMapping("information/{id}/update")
    public ResponseEntity<?> updateInformation(@PathVariable("id") int informationId,
                                               @RequestBody Information information) {
        return ResponseEntity.ok(informationService.updateInformation(informationId, information));
    }
}
