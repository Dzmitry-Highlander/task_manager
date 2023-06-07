package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExecutorDTO {
    @JsonProperty("executor_id")
    private Long id;
    @JsonProperty("name")
    private String name;

    public ExecutorDTO() {
    }

    public ExecutorDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
