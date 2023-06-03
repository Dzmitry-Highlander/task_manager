package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class TaskCreateDTO {
    @JsonProperty("header")
    private String header;
    @JsonProperty("description")
    private String description;
    @JsonProperty("deadline")
    private LocalDateTime deadline;
    @JsonProperty("status")
    private int status;
}
