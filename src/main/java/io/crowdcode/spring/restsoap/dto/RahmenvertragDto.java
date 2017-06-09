package io.crowdcode.spring.restsoap.dto;

import java.io.Serializable;

public class RahmenvertragDto implements Serializable{

    private static final long serialVersionUID = -5106731168761398947L;

    private String typ;

    private String name;

    public RahmenvertragDto() {
    }

    public RahmenvertragDto(String name, String typ) {
        this.name = name;
        this.typ = typ;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
