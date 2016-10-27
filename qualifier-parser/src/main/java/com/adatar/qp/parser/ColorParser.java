package com.adatar.qp.parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ColorParser extends QualifierParser {

    private static HashSet<String> COLORS;

    public ColorParser(){
        COLORS = new HashSet<>();
        COLORS.add("blue");
        COLORS.add("black");
        COLORS.add("violet");
        COLORS.add("pink");
        COLORS.add("red");
        COLORS.add("yellow");
        COLORS.add("orange");
        COLORS.add("white");
        COLORS.add("grey");
        COLORS.add("green");
        COLORS.add("brown");
    }

    public Slate parse(Slate workingSlate){

        String modifiedQ = workingSlate.modQ;
        List<String> foundColors = findColors(modifiedQ);

        modifiedQ = removeQualifier(modifiedQ, foundColors);
        workingSlate.colors = foundColors;
        workingSlate.modQ = modifiedQ;

        return workingSlate;
    }

    private List<String> findColors(String modQ){
        List<String> parsedColors = new ArrayList<>();
        List<String> qTokens = tokenizeQ(modQ, 1);

        for(String token : qTokens)
            if(COLORS.contains(token))
                parsedColors.add(token);

        return parsedColors;
    }
}
