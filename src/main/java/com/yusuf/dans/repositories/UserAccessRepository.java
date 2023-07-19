package com.yusuf.dans.repositories;

import com.yusuf.dans.Entity.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccessRepository extends JpaRepository<UserAccess, Integer> {

    UserAccess findByUsername(String username);

    @Query(value = "SELECT CURRENT_TIMESTAMP", nativeQuery = true)
    String dBServerTime();

}
