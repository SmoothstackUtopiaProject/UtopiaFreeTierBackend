package com.ss.utopia.repositories;

import com.ss.utopia.models.UserToken;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, String> {
  // if token was issued for user in the last 15 minutes
  @Query(
    value = "SELECT * FROM user_token  WHERE user_id = ?1 AND expiration_time > ?2",
    nativeQuery = true
  )
  List<UserToken> findTokenIssuedInLast15Min(Integer userId, Date before);
}
