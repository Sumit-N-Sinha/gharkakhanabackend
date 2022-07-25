package com.Gharkakhana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gharkakhana.entity.Vendor;
@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
