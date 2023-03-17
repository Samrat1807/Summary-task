package com.samrat.summarytask.controller;

import com.samrat.summarytask.payload.*;
import com.samrat.summarytask.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/summary")
    public ResponseEntity<List<TransactionSummary>> getTransactionSummary(){
        try{
            return new ResponseEntity<>(transactionService.getTransactionSummary(), HttpStatus.OK);
        }catch(IOException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
