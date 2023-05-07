package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BalanceRepository {
    private final Map<Long, BigDecimal> storage
            = new HashMap<>(Map.of(1L,BigDecimal.TEN));

    public BigDecimal getBalanceForId(Long accId) {
        return storage.get(accId);
    }

    public BigDecimal seve(Long to, BigDecimal amount) {
        BigDecimal currentBalance=storage.get(to);
        if (currentBalance==null){
            storage.put(to,amount);
            return amount;
        }else {
            BigDecimal updateBalance=currentBalance.add(amount);
            storage.put(to,updateBalance);
            return updateBalance;
        }

    }
    public void save(Long id, BigDecimal amount) {
        storage.put(id,amount);
        }

    }


