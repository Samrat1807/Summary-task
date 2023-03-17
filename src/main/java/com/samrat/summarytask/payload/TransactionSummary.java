package com.samrat.summarytask.payload;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionSummary {
    private String month;
    private long totalAmount;
    private int transactionCount;
}
