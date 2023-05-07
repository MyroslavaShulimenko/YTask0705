package com.example.demo.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class TrasferBalance {
    private  Long from;
    private Long to;
    private BigDecimal amount;
}
