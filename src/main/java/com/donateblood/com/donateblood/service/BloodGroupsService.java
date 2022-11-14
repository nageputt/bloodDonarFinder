package com.donateblood.com.donateblood.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donateblood.com.donateblood.model.BloodGroups;
import com.donateblood.com.donateblood.repo.BloodGroupRepo;


@Service
public class BloodGroupsService {
    @Autowired
    BloodGroupRepo bloodGroupRepo;
    public List<String> getBloodGroups() {
        List<BloodGroups>  groupsList=bloodGroupRepo.findAll();
        List<String> bloodGroupList =groupsList.stream().map(BloodGroups::getBloodGroupName).collect(Collectors.toList());
        return bloodGroupList;
    }
}
