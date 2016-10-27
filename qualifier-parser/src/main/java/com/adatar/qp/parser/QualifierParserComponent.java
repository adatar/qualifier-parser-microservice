package com.adatar.qp.parser;

import com.adatar.qp.response.ServiceResponse;
import com.adatar.qp.util.Tokenizer;
import java.util.ArrayList;
import java.util.List;

public class QualifierParserComponent {

    private List<QualifierParser> parserList;

    public QualifierParserComponent(){
        parserList = new ArrayList<>();
        parserList.add(new BrandParser());
        parserList.add(new ColorParser());
        parserList.add(new SizeParser());
        parserList.add(new GenderParser());
    }

    public ServiceResponse parse(String q){

        q = processQ(q);
        List<String> qTokens = Tokenizer.tokenize(q);
        Slate workingSlate = new Slate(q, q, qTokens);

        for(int i = qTokens.size(); i >= 1 && qTokens.size() > 0; i--){

            workingSlate.qNgrams = getNgrams(qTokens, i);

            for (QualifierParser parser : parserList)
                workingSlate = parser.parse(workingSlate);

        }

        return buildResponse(workingSlate);
    }

    private ArrayList<String> getNgrams(List<String> qTokens, int size){
        ArrayList<String> nGrams = new ArrayList<>();

        return nGrams;
    }

    private String processQ(String q){
        q = q.toLowerCase()
                .trim()
                .replaceAll("\\s+", " ");

        return q;
    }

    private ServiceResponse buildResponse(Slate workingSlate){
        ServiceResponse response = new ServiceResponse(
                workingSlate.getQ(),
                workingSlate.modQ,
                workingSlate.size,
                workingSlate.colors,
                workingSlate.gender,
                workingSlate.metrics,
                workingSlate.brands
                );

        return response;
    }
}
