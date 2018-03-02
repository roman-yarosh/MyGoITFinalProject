package ua.goit.finall.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class User extends BaseEntity{
    private String userName;
    private String password;
}
