package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusCreateDTO {
    @JsonProperty("status")
    private String status;

    public StatusCreateDTO() {
    }

    public StatusCreateDTO(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
