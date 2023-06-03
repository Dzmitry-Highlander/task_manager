package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class TaskCreateDTO {
    @JsonProperty("header")
    private String header;
    @JsonProperty("description")
    private String description;
    @JsonProperty("deadline")
    private LocalDate deadline;
    @JsonProperty("status")
    private int status;
    @JsonProperty("executor")
    private int executorID;

    public TaskCreateDTO() {
    }

    public TaskCreateDTO(String header, String description, LocalDate deadline, int status) {
        this.header = header;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.executorID = 1;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getExecutorID() {
        return executorID;
    }

    public void setExecutorID(int executorID) {
        this.executorID = executorID;
    }
}
