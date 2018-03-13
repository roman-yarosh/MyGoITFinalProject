package ua.goit.finall.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "event_types")
public class EventType extends BaseEntity {

    @Column(name = "TYPE")
    private String type;

    @Column(name = "RATE")
    private Double rate;

    public EventType() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EventType{");
        sb.append("id='").append(super.getId()).append('\'');
        sb.append("type='").append(type).append('\'');
        sb.append(", rate=").append(rate);
        sb.append('}');
        return sb.toString();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
