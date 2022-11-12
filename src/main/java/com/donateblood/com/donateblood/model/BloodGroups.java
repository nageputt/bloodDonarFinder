package com.donateblood.com.donateblood.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "BLOOD_GROUPS")
public class BloodGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int bloodId;
    private String bloodGroupName;
}
