package com.laboramus.sales.configs;

import java.math.BigDecimal;

public class BigdecimalOperations {
    //Add BigDecimal Values
    public static BigDecimal addAmount(BigDecimal... addends) {
        BigDecimal sum = BigDecimal.ZERO;
        if (addends != null) {
            for (BigDecimal addend : addends) {
                if (addend == null) {
                    addend = BigDecimal.ZERO;
                }
                sum = sum.add(addend);
            }
        }
        return sum;
    }
}
