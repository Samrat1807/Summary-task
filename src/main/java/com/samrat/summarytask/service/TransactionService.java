package com.samrat.summarytask.service;

import com.samrat.summarytask.csv.*;
import com.samrat.summarytask.excep.*;
import com.samrat.summarytask.payload.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

@Service
public class TransactionService {

    @Autowired
    private GetTransaction getTransaction;

    private static final DateTimeFormatter MONTH_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM");

    public List<TransactionSummary> getTransactionSummary() throws IOException {
        List<Transaction> transactions = getTransaction.readCSVFile();

        if (transactions.isEmpty()) {
            throw new EmptyFileException("The input file is empty.");
        }

        Map<String, List<Transaction>> transactionsByMonth = transactions.stream().collect(Collectors.
                groupingBy(transaction -> transaction.getDate().format(MONTH_FORMAT)));

        List<TransactionSummary> result = transactionsByMonth.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(entry -> {
                    String month = entry.getKey();
                    long totalAmount = entry.getValue().stream().mapToLong(Transaction::getAmount).sum();
                    int transactionCount = entry.getValue().size();
                    return new TransactionSummary(month, totalAmount, transactionCount);
                })
                .collect(Collectors.toList());
        return result;
    }
}
