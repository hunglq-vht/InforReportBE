package com.information.api.service.impl;

import com.information.api.configs.InformationStatus;
import com.information.api.configs.InformationType;
import com.information.api.models.Information;
import com.information.api.repository.InformationRepository;
import com.information.api.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

@Service
public class InformationServiceImpl implements InformationService {
    private InformationRepository informationRepository;

    @Autowired
    public InformationServiceImpl(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    @Override
    public List<Information> getAllInformation() {
        return informationRepository.findAll();
    }

    @Override
    public Information createInformation(Information information) {
        Information newInformation = new Information();
        newInformation.setNote(information.getNote());
        newInformation.setDepartment(information.getDepartment());
        newInformation.setReporter(information.getReporter());
        newInformation.setSource(information.getSource());
        newInformation.setType(information.getType());
        newInformation.setStatus(information.getStatus());
        newInformation.setCreatedDate(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));


        return informationRepository.save(newInformation);
    }

    @Override
    public Information updateInformation(int id, Information information) {
        if (informationRepository.findById(id).isEmpty()) {
            return null;
        }
        Optional<Information> currentInformation = informationRepository.findById(id);
        if (currentInformation.isPresent()) {
            currentInformation.get().setModifiedDate(System.currentTimeMillis() / 1000);
            currentInformation.get().setDepartment(information.getDepartment());
            currentInformation.get().setNote(information.getNote());
            currentInformation.get().setReporter(information.getReporter());
            currentInformation.get().setSource(information.getSource());
            currentInformation.get().setStatus(information.getStatus());
            currentInformation.get().setType(information.getType());
            return informationRepository.save(currentInformation.get());
        }
        return null;
    }

    @Override
    public List<Information> getInformationByParams(List<InformationStatus> statuses,
                                                    List<InformationType> types, long fromTime, long toTime) {
        List<Information> result = informationRepository.findAll();
        if (!statuses.isEmpty()) {
            result =
                    result.stream().filter(information -> statuses.contains(information.getStatus())).toList();
        }
        if (!types.isEmpty()) {
            result = result.stream().filter(information -> types.contains(information.getType())).toList();
        }
        if (toTime != 0 && fromTime != 0) {
            result =
                    result.stream().filter(information -> information.getCreatedDate() >= fromTime && information.getCreatedDate() <= toTime).toList();
        }
        return result;
    }

    @Override
    public boolean deleteInformation(int informationId) {
        if (!informationRepository.existsById(informationId)) return false;
        informationRepository.deleteById(informationId);
        return true;
    }
}