package com.example.sslserver;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    //Creating a sample list to store objectanable words without using db
    private List<String> objectinableWordList = Arrays.asList("damn","crap");

    private Map<String, List<String>> commentsForProduts = new HashMap<String, List<String>>();

    String validate(String productname, String comment) {
        for(String objectionableWord: objectinableWordList) {
            if(comment.toLowerCase().contains(objectionableWord.toLowerCase())) {
                return "Your comment contains objectionable word [ " + objectionableWord + " ] . Please review your comment. ";
            }
        }
        return null;
    }

    String addComment(String productname, String comment) {
        String response =validate(productname, comment);
        if (response != null) {
            return  response;
        } else {
            if (commentsForProduts.containsKey(productname)) {
                List<String> tempComments= commentsForProduts.get(productname);
                tempComments.add(comment);
                commentsForProduts.put(productname, tempComments);
            } else {
                commentsForProduts.put(productname, Arrays.asList(comment));
            }
            return "Comment successfully saved";
        }
    }
}
