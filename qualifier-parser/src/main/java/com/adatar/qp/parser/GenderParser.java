package com.adatar.qp.parser;

import java.util.HashSet;
import java.util.List;

public class GenderParser extends QualifierParser{

    private static HashSet<String> GENDERS;

    public GenderParser(){
        GENDERS = new HashSet<>();
        GENDERS.add("mens");
        GENDERS.add("man");
        GENDERS.add("men's");
        GENDERS.add("men");
        GENDERS.add("guys");
        GENDERS.add("boy");
        GENDERS.add("boys");
        GENDERS.add("boy's");
        GENDERS.add("women");
        GENDERS.add("woman");
        GENDERS.add("women's");
        GENDERS.add("woman's");
        GENDERS.add("girl");
        GENDERS.add("girls");
        GENDERS.add("girl'");
        GENDERS.add("male");
        GENDERS.add("males");
        GENDERS.add("male's");
        GENDERS.add("female");
        GENDERS.add("female's");
        GENDERS.add("females");

    }

    public Slate parse(Slate workingSlate){

        String modifiedQ = workingSlate.modQ;
        String foundGender = parseGender(modifiedQ);

        modifiedQ = removeQualifier(modifiedQ, foundGender);
        workingSlate.gender = foundGender;
        workingSlate.modQ = modifiedQ;

        return workingSlate;
    }

    private String parseGender(String modQ){
        List<String> qTokens = tokenizeQ(modQ, 1);

        for(String token : qTokens)
            if(GENDERS.contains(token)) {
                return token;
            }

        return "";

    }
}
