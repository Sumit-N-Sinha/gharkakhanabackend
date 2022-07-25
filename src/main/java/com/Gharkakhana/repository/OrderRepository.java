package com.Gharkakhana.repository;

import com.Gharkakhana.entity.Order1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order1, Integer>{

}
