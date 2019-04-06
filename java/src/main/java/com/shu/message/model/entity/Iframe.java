package com.shu.message.model.entity;

public class Iframe {
    private Integer id;

    private String host;

    public Integer getId() {
        return id;
    }

    public Iframe() {
    }

    public Iframe(String host) {
        this.host = host;
    }

    public Iframe(Integer id, String host) {
        this.id = id;
        this.host = host;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }
}