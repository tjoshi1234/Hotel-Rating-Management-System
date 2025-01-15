package com.tapan.rating.service.repositories;

import com.tapan.rating.service.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating,String> {

    @Query("SELECT r FROM Rating r WHERE r.userId = :userId")
    List<Rating> findByUserId(@Param("userId") String userId);

    @Query("SELECT r FROM Rating r WHERE r.hotelId = :hotelId")
    List<Rating> findByHotelId(@Param("hotelId") String hotelId);


}
