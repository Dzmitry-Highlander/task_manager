package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExecutorCreateUpdateDTO {
    @JsonProperty("executor_task_id")
    private Long executorTaskID;
    @JsonProperty("executor_id")
    private Long executorID;
    @JsonProperty("task_id")
    private Long taskID;

    public ExecutorCreateUpdateDTO() {
    }

    public ExecutorCreateUpdateDTO(Long executorTaskID, Long executorID, Long taskID) {
        this.executorTaskID = executorTaskID;
        this.executorID = executorID;
        this.taskID = taskID;
    }

    public Long getExecutorTaskID() {
        return executorTaskID;
    }

    public void setExecutorTaskID(Long executorTaskID) {
        this.executorTaskID = executorTaskID;
    }

    public Long getExecutorID() {
        return executorID;
    }

    public void setExecutorID(Long executorID) {
        this.executorID = executorID;
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }
}
