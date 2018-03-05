package ua.goit.finall.model;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity{
    private String userName;
    private String password;
}
