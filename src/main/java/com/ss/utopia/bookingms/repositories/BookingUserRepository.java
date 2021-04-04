package com.ss.utopia.bookingms.repositories;
import java.util.Optional;

import javax.transaction.Transactional;

import com.ss.utopia.bookingms.models.BookingUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingUserRepository extends JpaRepository<BookingUser, Integer> {

  @Query(value = "SELECT * FROM booking_user WHERE user_id = ?1", nativeQuery = true)
  Optional<BookingUser> findByUserId(Integer userId);

  @Modifying
  @Transactional
  @Query(value="DELETE from booking_user WHERE booking_id = ?1", nativeQuery=true)
  void deleteByBookingId(Integer bookingId);
}