package ua.goit.finall.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Role extends BaseEntity{
    private String name;
}
