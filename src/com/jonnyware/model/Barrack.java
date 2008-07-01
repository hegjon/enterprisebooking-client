package com.jonnyware.model;

public class Barrack extends BaseModel {

    private String code;
    private String name;
    private int camp_id;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCamp_id() {
        return camp_id;
    }

    public void setCamp_id(int camp_id) {
        this.camp_id = camp_id;
    }
}
