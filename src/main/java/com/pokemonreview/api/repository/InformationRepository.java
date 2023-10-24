package com.pokemonreview.api.repository;

import com.pokemonreview.api.configs.InformationType;
import com.pokemonreview.api.models.Information;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InformationRepository extends JpaRepository<Information, Integer> {
    Optional<Information> findBySource(String source);

    List<Information> findBySourceIn(List<String> sources);

    List<Information> findByTypeIn(List<InformationType> types);
}