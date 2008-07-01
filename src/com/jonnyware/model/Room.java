package com.jonnyware.model;

public class Room extends BaseModel {
    private String code;
    private int beds;
    private int status;
    private int barrack_id;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBarrack_id() {
        return barrack_id;
    }

    public void setBarrack_id(int barrack_id) {
        this.barrack_id = barrack_id;
    }
    
    
}
