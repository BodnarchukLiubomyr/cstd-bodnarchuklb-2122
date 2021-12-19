package com.company.model.entity.service;

public class Service {

    private int id;
    private String service_en;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService_en() {
        return service_en;
    }

    public void setService_en(String service_en) {
        this.service_en = service_en;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", service_en='" + service_en + '\'' +
                '}';
    }
}
