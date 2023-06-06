package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExecutorCreateDTO {
    @JsonProperty("name")
    private String name;

    public ExecutorCreateDTO() {
    }

    public ExecutorCreateDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
