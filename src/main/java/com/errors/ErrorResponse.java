package com.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ErrorResponse {

    @JsonProperty("status")
    protected int status;
    @JsonProperty("menssage")
    protected String menssage;
    @JsonProperty("error")
    protected String error;
    @JsonProperty("cause")
    protected List<ErrorCause> listCause;

    public ErrorResponse(int status, String menssage, String error, List<ErrorCause> listCause) {
        this.status = status;
        this.menssage = menssage;
        this.error = error;
        this.listCause = listCause;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMenssage(String menssage) {
        this.menssage = menssage;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setListCause(List<ErrorCause> listCause) {
        this.listCause = listCause;
    }

    public int getStatus() {
        return status;
    }

    public String getMenssage() {
        return menssage;
    }


    public String getError() {
        return error;
    }


    public List<ErrorCause> getInvalidCause() {
        return listCause;
    }

}
