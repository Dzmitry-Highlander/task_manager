package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class TaskDTO {
    //TODO добавить поле для delete()
    @JsonProperty("task_id")
    private Long id;
    @JsonProperty("header")
    private String header;
    @JsonProperty("description")
    private String description;
    @JsonProperty("deadline")
    private LocalDate deadline;
    @JsonProperty("status")
    private StatusDTO status;

    public TaskDTO() {
    }

    public TaskDTO(Long id, String header, String description, LocalDate deadline, StatusDTO status) {
        this.id = id;
        this.header = header;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }
}
