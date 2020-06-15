package com.sipc.catalina.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "todo")
@EnableConfigurationProperties(TodoListConfig.class)
@Component
public class TodoListConfig {

    private String data;

    private String thing;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }
}
