package ua.goit.finall.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseEntity{
    private String userName;
    private String password;
}
