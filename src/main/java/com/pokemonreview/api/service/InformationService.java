package com.pokemonreview.api.service;

import com.pokemonreview.api.configs.InformationStatus;
import com.pokemonreview.api.configs.InformationType;
import com.pokemonreview.api.models.Information;

import java.util.List;

public interface InformationService {
    List<Information> getAllInformation();

    Information createInformation(Information information);

    Information updateInformation(int id, Information information);

    List<Information> getInformationByParams(List<InformationStatus> statuses, List<InformationType> types, long fromTime, long toTime);
}
