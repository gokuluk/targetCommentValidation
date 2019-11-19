package com.example.sslserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/product")
public class CommentsController {

    @Autowired
    ProductService productService;

    @PostMapping("/addComment/{productName}/")
    public ResponseEntity addComment(@PathVariable String productName, @RequestBody String comment){
        String response = productService.addComment(productName,comment);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
