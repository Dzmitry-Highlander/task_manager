package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

import by.it_academy.jd2.Mk_JD2_98_23.core.enums.Status;

import java.time.LocalDateTime;

public class TaskDTO {
    private String header;
    private String description;
    private LocalDateTime deadline;
    private int status;

    public TaskDTO() {
    }

    public TaskDTO(String header, String description, LocalDateTime deadline, int status) {
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

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
