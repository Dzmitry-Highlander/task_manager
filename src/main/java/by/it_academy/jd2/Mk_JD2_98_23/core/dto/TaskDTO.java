package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

import java.time.LocalDate;

public class TaskDTO {
    private String header;
    private String description;
    private LocalDate deadline;
    private String status;

    public TaskDTO() {
    }

    public TaskDTO(String header, String description, LocalDate deadline, String status) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
