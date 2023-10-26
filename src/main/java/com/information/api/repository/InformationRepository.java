package com.information.api.repository;

import com.information.api.configs.InformationType;
import com.information.api.models.Information;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InformationRepository extends JpaRepository<Information, Integer> {
    Optional<Information> findBySource(String source);

    List<Information> findBySourceIn(List<String> sources);

    List<Information> findByTypeIn(List<InformationType> types);
}