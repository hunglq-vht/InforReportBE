package com.information.api.service;

import com.information.api.configs.InformationStatus;
import com.information.api.configs.InformationType;
import com.information.api.models.Information;

import java.util.List;

public interface InformationService {
    List<Information> getAllInformation();

    Information createInformation(Information information);

    Information updateInformation(int id, Information information);

    List<Information> getInformationByParams(List<InformationStatus> statuses, List<InformationType> types, long fromTime, long toTime);

    boolean deleteInformation(int id);
}
