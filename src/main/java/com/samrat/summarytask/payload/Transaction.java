package com.samrat.summarytask.payload;

import lombok.*;
import java.time.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private LocalDate date;
    private int amount;
    private String description;

}
