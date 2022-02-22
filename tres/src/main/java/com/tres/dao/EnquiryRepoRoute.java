package com.tres.dao;

import com.tres.compositekey.CompositeKeyRoute;
import com.tres.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryRepoRoute extends JpaRepository<Route, CompositeKeyRoute> {

}
