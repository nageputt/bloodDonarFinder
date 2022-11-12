package com.donateblood.com.donateblood.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "BLOOD_GROUPS")
public class BloodGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer bloodId;
    private String bloodGroupName;
}
