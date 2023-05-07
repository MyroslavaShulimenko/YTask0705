package com.example.demo;

import com.example.demo.model.TrasferBalance;
import com.example.demo.servaice.BankServaice;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
@Slf4j
@RestController("/balance")
@AllArgsConstructor
public class BalanseCpontroller {
    private BankServaice bankServaice;
    @GetMapping("/{accId}")
    public BigDecimal getBalance(@PathVariable long accId)  {
        return bankServaice.getbalance(accId);
    }
    @PostMapping("/add")
    public BigDecimal   addMoney(@PathVariable long accId,
                                 @RequestBody TrasferBalance trasferBalance) {
        return bankServaice.addMoney(trasferBalance.getTo(),trasferBalance.getAmount());
    }
    @PostMapping("/{transfer}")
    public void   transfer(
                                 @RequestBody TrasferBalance trasferBalance) {

         bankServaice.maketTranfer(trasferBalance);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String handler(IllegalArgumentException e){
log.error(e.getMessage());
return "Mama, ya slomalsya!";
    }
}
