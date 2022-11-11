package com.donateblood.com.donateblood.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_REGISTRATION")
@Data
public class UserRegistration {

    @Id
    private String userId;
    private String fullName;
    private Integer phoneNumber;
    private String bloodGroup;
    private String country;
    private String state;
    private String district;
    private String landlineNumber;
    private String availability;


}
