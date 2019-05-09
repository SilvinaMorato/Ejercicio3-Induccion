package com.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorCause {

    @JsonProperty("code")
    protected String code;
    @JsonProperty("description")
    protected String description;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public ErrorCause(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
