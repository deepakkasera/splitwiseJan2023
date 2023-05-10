package com.scaler.splitwisejan2023.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groups") // To give the name of the table.
public class Group extends BaseModel {
    private String name;
    @ManyToMany
    private List<User> participants;
    @ManyToMany
    private List<User> admins;
    private String description;
    @ManyToOne
    private User createdBy;
    @OneToMany
    private List<Expense> expenses;
    // G : E
    // 1   m
    // 1   1
    // 1 : m
    //   expenses
    //   |         | group_id
}
