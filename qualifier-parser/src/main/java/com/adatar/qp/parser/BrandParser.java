package com.adatar.qp.parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BrandParser extends QualifierParser {

    private static HashSet<String> BRANDS;

    public BrandParser(){
        BRANDS = new HashSet<>();
        BRANDS.add("apple");
        BRANDS.add("black & decker");
        BRANDS.add("nike");
        BRANDS.add("adidas");
        BRANDS.add("levi's");
        BRANDS.add("levis");
        BRANDS.add("us polo assn");
        BRANDS.add("us polo");
        BRANDS.add("zara");
    }

    @Override
    public Slate parse(Slate workingSlate){

        List<String> foundBrands = findBrands(workingSlate.qNgrams);
        workingSlate.brands = foundBrands;

        removeQualifier(workingSlate, foundBrands);

        return workingSlate;
    }

    private List<String> findBrands(List<String> qNgrams){
        List<String> parsedBrands = new ArrayList<>();

        for(String token : qNgrams)
            if(BRANDS.contains(token))
                parsedBrands.add(token);

        return parsedBrands;
    }
}