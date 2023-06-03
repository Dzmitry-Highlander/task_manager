package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

import java.time.LocalDate;

public class TaskDTO {
    private String header;
    private String description;
    private LocalDate deadline;
    private int status;
    private int executorID;

    public TaskDTO() {
    }

    public TaskDTO(String header, String description, LocalDate deadline, int status, int executorID) {
        this.header = header;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.executorID = executorID;
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
