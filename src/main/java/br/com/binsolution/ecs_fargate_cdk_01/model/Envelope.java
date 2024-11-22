package br.com.binsolution.ecs_fargate_cdk_01.model;

import java.util.Objects;

public class Envelope {
    private String eventType;
    private String data;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Envelope envelope = (Envelope) o;
        return Objects.equals(eventType, envelope.eventType) && Objects.equals(data, envelope.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventType, data);
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "eventType='" + eventType + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
