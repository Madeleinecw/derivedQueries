package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findWhiskysByYear(Integer year);
    List<Whisky> findWhiskysByDistilleryIdAndYear(Long id, Integer year);
    List<Whisky> findWhiskysByDistillery(Distillery distillery);
}
