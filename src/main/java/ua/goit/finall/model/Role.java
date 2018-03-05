package ua.goit.finall.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends BaseEntity{
    private String name;
}
