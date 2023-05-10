package com.scaler.splitwisejan2023.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity //To create table for currency in DB.
public class Currency extends BaseModel {
    private String name;
}
