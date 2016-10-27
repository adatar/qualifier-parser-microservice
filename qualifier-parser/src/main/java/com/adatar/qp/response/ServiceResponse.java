package com.adatar.qp.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ServiceResponse {

    private String q;

    private String modQ;

    private String size;

    private List<String> colors;

    private String gender;

    private String metrics;

    private List<String> brands;

    public ServiceResponse(){}

    public ServiceResponse(String q){
        this.q = q;
    }

    public ServiceResponse(String q, String modQ, String size, List<String> colors, String gender, String metrics, List<String> brands){
        this.brands = brands;
        this.size = size;
        this.colors = colors;
        this.gender = gender;
        this.metrics = metrics;
        this.q = q;
        this.modQ = modQ;
    }

    @JsonProperty
    public String getSize() {
        return StringUtils.isEmpty(size) ? StringUtils.EMPTY : size;
    }


    @JsonProperty
    public List<String> getColors() {
        return colors == null ? new ArrayList<>(0) : colors;
    }


    @JsonProperty
    public String getGender() {
        return StringUtils.isEmpty(gender) ? StringUtils.EMPTY : gender;
    }


    @JsonProperty
    public String getMetrics() {
        return StringUtils.isEmpty(metrics) ? StringUtils.EMPTY : metrics;
    }


    @JsonProperty
    public List<String>  getBrands() {
        return brands == null ? new ArrayList<>(0) : brands;
    }

    @JsonProperty
    public String getQ() {
        return q;
    }

    @JsonProperty
    public String getModQ() {
        return modQ;
    }

    @JsonProperty
    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty
    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    @JsonProperty
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty
    public void setMetrics(String metrics) {
        this.metrics = metrics;
    }

    @JsonProperty
    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    @JsonProperty
    public void setQ(String q) {
        this.q = q;
    }

    @JsonProperty
    public void setModQ(String modQ) {
        this.modQ = modQ;
    }
}
