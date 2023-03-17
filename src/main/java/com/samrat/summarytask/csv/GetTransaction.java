package com.samrat.summarytask.csv;

import com.samrat.summarytask.payload.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.zip.*;

@Component
public class GetTransaction {

    //private static final String TRANSACTION_DETAILS = "transaction-details.csv";
    //private static final String TRANSACTION_DETAILS ="C:/Users/user/Desktop/data.csv.gz";
    private static final String TRANSACTION_DETAILS ="src/main/resources/data.csv.gz";

    public List<Transaction> readCSVFile() throws  IOException{
        List<Transaction> transactions = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(TRANSACTION_DETAILS);
        GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(gzipInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line=bufferedReader.readLine()) != null) {
                if (!line.startsWith("date")) {
                    String[] fields = line.split(",");
                    LocalDate date = LocalDate.parse(fields[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    int amount = Integer.parseInt(fields[1]);
                    String description = fields[2];
                    transactions.add(new Transaction(date, amount, description));
                }
            }
        bufferedReader.close();
        inputStreamReader.close();
        gzipInputStream.close();
        fileInputStream.close();
        return transactions;
    }
}

