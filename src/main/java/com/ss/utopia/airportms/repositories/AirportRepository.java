package com.ss.utopia.airportms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.utopia.airportms.models.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {}