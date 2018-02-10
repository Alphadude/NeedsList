package com.ng.needslist.needslist.Modal;

public class Response<T> {
    private String status;
    private Integer status_code;
    private String message;
    private T data;
    private String error;

    public Response(String status, Integer status_code, String message, T data,String error) {
        this.status = status;
        this.status_code = status_code;
        this.message = message;
        this.data = data;
        this.error = error;
    }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStatus_code() {
        return status_code;
    }

    public void setStatus_code(Integer status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
