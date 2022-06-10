package com.tres.dao;

import com.tres.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryStationRepo extends JpaRepository<Station, String> {
}
