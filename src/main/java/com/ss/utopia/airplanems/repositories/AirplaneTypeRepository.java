package com.ss.utopia.airplanems.repositories;

import com.ss.utopia.airplanems.models.AirplaneType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneTypeRepository extends JpaRepository<AirplaneType, Integer> {}