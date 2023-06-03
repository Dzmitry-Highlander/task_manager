package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

import java.time.LocalDateTime;

enum Status {
    UNASSIGNED,
    PENDING,
    ACCEPTED,
    STARTED,
    COMPLETED
}

public class TaskDTO {
    private String header;
    private String description;
    private LocalDateTime deadline;
    private Status status;
}
