package ua.goit.finall.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "event_type")
public class EventType extends BaseEntity {
    private String type;
    private Double rate;

    @OneToOne(mappedBy = "type")
    private Event event;

    public EventType() {
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "EventType{" +
                "type='" + type + '\'' +
                ", rate=" + rate +
                '}';
    }
}
