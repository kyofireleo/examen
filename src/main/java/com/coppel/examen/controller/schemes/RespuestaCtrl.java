package com.coppel.examen.controller.schemes;

public class RespuestaCtrl {
    private boolean isError;
    private int status;
    private Object data;
    
    public RespuestaCtrl(boolean isError, int status, Object data) {
        this.isError = isError;
        this.status = status;
        this.data = data;
    }
    
    public boolean isError() {
        return isError;
    }
    public void setError(boolean isError) {
        this.isError = isError;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    
}
