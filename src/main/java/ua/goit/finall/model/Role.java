package ua.goit.finall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> userSet;

    public Role() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append("id='").append(super.getId()).append('\'');
        sb.append("name='").append(name).append('\'');
        sb.append(", userSet=").append(userSet);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
