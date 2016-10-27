package com.adatar.qp.parser;

import java.util.HashSet;
import java.util.List;

public class SizeParser extends QualifierParser {

    private static HashSet<String> SIZES;

    public SizeParser(){
        SIZES = new HashSet<>();

        SIZES.add("extra small");
        SIZES.add("small");
        SIZES.add("medium");
        SIZES.add("large");
        SIZES.add("extra large");

        SIZES.add("xs");
        SIZES.add("s");
        SIZES.add("m");
        SIZES.add("l");
        SIZES.add("xl");
        SIZES.add("xxl");
    }

    @Override
    public Slate parse(Slate workingSlate){

        String modifiedQ = workingSlate.modQ;
        String foundSize = parseSize(modifiedQ);

        modifiedQ = removeQualifier(modifiedQ, foundSize);
        workingSlate.size = foundSize;
        workingSlate.modQ = modifiedQ;

        return workingSlate;
    }

    private String parseSize(String modQ){
        List<String> qTokens = tokenizeQ(modQ, 2);

        for(String token : qTokens)
            if(SIZES.contains(token)) {
                return token;
            }

        return "";

    }

}
