package com.example.csi2_23.trabajoandroid;

import java.io.Serializable;

/**
 * Created by Master on 15/12/2016.
 */

public class Alumno implements Serializable {
    private Integer idAlumn;
    private String name;
    private String surname;
    private Integer phonenumber;
    private String email;
    private Integer subject;
    private Float mark;


    public Alumno() {
        this.idAlumn = -1;
        this.name = "";
        this.surname = "";
        this.phonenumber = 0;
        this.email = "";
        this.subject = 0;
        this.mark = 0.0f;
    }

    public Alumno(Integer idAlumn, String name, String surname, Integer phonenumber, String email, Integer subject, Float mark) {
        this.idAlumn = idAlumn;
        this.name = name;
        this.surname = surname;
        this.phonenumber = phonenumber;
        this.email = email;
        this.subject = subject;
        this.mark = mark;
    }

    public Integer getIdAlumn() {
        return idAlumn;
    }

    public void setIdAlumn(Integer idAlumn) {
        this.idAlumn = idAlumn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public Float getMark() {
        return mark;
    }

    public void setMark(Float mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "idAlumn=" + idAlumn +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phonenumber=" + phonenumber +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", mark=" + mark +
                '}';
    }
}
