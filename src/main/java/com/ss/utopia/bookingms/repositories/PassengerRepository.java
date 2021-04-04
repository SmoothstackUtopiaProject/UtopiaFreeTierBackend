package com.ss.utopia.bookingms.repositories;

import java.util.List;
import java.util.Optional;

import com.ss.utopia.bookingms.models.Passenger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

  @Query(value = "SELECT * FROM passenger WHERE booking_id = ?1", nativeQuery = true)
  Optional<Passenger> findByBookingId(Integer bookingId);

  @Query(value = "SELECT * FROM passenger WHERE passport_id = ?1", nativeQuery = true)
  List<Passenger> findByPassportId(String passportId);
}