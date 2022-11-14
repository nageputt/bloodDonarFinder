package com.donateblood.com.donateblood.repo;

import com.donateblood.com.donateblood.model.BloodGroups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodGroupRepo extends JpaRepository<BloodGroups,Integer> {
}

