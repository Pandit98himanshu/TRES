package com.tres.dao;

import com.tres.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryTrainRepo extends JpaRepository<Train, Integer> {
}
