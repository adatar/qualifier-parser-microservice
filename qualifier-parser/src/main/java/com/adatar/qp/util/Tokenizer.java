package com.adatar.qp.util;

import java.util.Arrays;
import java.util.List;

public class Tokenizer {

    public static List<String> tokenize(String string){
        String[] tokens = string.split(" ");
        return Arrays.asList(tokens);
    }
}
