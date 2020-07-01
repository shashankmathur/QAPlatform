package com.example.QAPlatform.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
public class Company {
    @Id
    private String companyId;
    private String companyname;
    private String info;
    private LocalDate createdOn;

    public Company() {
    }

    public Company(@JsonProperty("companyId") String companyId,@JsonProperty("companyname") String companyname, @JsonProperty("info") String info) {
        this.companyId = companyId;
        this.companyname = companyname;
        this.info = info;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyname;
    }

    public void setCompanyName(String companyName) {
        this.companyname = companyName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }
}
