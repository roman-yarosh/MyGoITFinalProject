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

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> eventList;

    public EventType() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EventType{");
        sb.append("id='").append(super.getId()).append('\'');
        sb.append("type='").append(type).append('\'');
        sb.append(", rate=").append(rate);
        sb.append(", eventList=").append(eventList);
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

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
