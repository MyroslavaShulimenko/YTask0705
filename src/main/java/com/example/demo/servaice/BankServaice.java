package com.example.demo.servaice;

import com.example.demo.model.TrasferBalance;
import com.example.demo.repository.BalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class BankServaice {
    private final BalanceRepository repository;

    public BigDecimal getbalance(Long accId) {
        BigDecimal balance = repository.getBalanceForId(accId);
        if (balance == null) {
            throw new IllegalArgumentException();
        }
        return balance;
    }

    public BigDecimal addMoney(Long to, BigDecimal amount) {
        BigDecimal currentBalance = repository.getBalanceForId(to);
        if (currentBalance == null) {
            repository.seve(to, amount);
            return amount;
        } else {
            BigDecimal updateBalance = currentBalance.add(amount);
            repository.seve(to, updateBalance);
            return updateBalance;
        }
    }
    public void maketTranfer(TrasferBalance trasferBalance) {
        BigDecimal fromBalance = repository.getBalanceForId(trasferBalance.getFrom());
        BigDecimal toBalance = repository.getBalanceForId(trasferBalance.getTo());
        if (fromBalance==null || toBalance==null){
            throw new IllegalArgumentException();
        }
        if (trasferBalance.getAmount().compareTo(fromBalance)>0)throw new IllegalArgumentException("no money");
        BigDecimal upDateFromBalance = fromBalance.subtract(trasferBalance.getAmount());
        BigDecimal upDateToBalance = toBalance.add(trasferBalance.getAmount());
repository.seve(trasferBalance.getFrom(),upDateFromBalance);
repository.seve(trasferBalance.getTo(),upDateToBalance);
    }
}
