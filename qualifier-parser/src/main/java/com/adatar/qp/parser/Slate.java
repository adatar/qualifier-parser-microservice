package com.adatar.qp.parser;

import java.util.List;

public class Slate {

    private String q;


    protected List<String> qTokens;

    protected List<String> qNgrams;

    protected String modQ;

    protected List<String> colors;

    protected List<String> brands;

    protected String gender;

    protected String metrics;

    protected String size;


    public Slate(String q, String modQ){
        this.q = q;
        this.modQ = modQ;
    }

    public Slate(String q, String modQ, List<String> qTokens){
        this.q = q;
        this.modQ = modQ;
    }

    public String getQ() {
        return q;
    }

}
