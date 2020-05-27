package me.seung.demowebmvc;

import javax.validation.constraints.NotBlank;

public class Event {

    private Integer id;
    @NotBlank
    private String name;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
