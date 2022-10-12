package com.coppel.examen.repository.tools;

public class Respuesta {
    private byte status;
    private String message;
    private int rows;
    
    public static final int OK = 1;
    public static final int ERROR = 0;
    
    public Respuesta(byte status, String message, int rows) {
        this.status = status;
        this.message = message;
        this.rows = rows;
    }
    
    public byte getStatus() {
        return status;
    }
    public void setStatus(byte status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
    
}
