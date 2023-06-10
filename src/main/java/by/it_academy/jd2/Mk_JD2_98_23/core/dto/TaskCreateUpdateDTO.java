package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class TaskCreateUpdateDTO {
    @JsonProperty("header")
    private String header;
    @JsonProperty("description")
    private String description;
    @JsonProperty("deadline")
    private LocalDate deadline;
    @JsonProperty("status_id")
    private Long status;

    public TaskCreateUpdateDTO() {
    }

    public TaskCreateUpdateDTO(String header, String description, LocalDate deadline, Long status) {
        this.header = header;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
