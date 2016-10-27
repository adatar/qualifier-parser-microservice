package com.adatar.qp.parser;

import com.adatar.qp.util.Tokenizer;
import java.util.List;

public abstract class QualifierParser {

    public abstract Slate parse(Slate response);


    public void removeQualifier(Slate workingSlate, List<String> qualifiers){
        for(String qualifier : qualifiers) {
            removeQualifier(workingSlate, qualifier);
        }
    }

    public void removeQualifier(Slate workingSlate, String qualifier){
        List<String> tokens = Tokenizer.tokenize(qualifier);
        workingSlate.qTokens.removeAll(tokens);
    }
}
