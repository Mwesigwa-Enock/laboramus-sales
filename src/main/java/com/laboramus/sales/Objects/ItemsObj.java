package com.laboramus.sales.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemsObj implements Serializable {
    private String item_type;
    private BigDecimal totalProfits;

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public BigDecimal getTotalProfits() {
        return totalProfits;
    }

    public void setTotalProfits(BigDecimal totalProfits) {
        this.totalProfits = totalProfits;
    }

    @Override
    public String toString() {
        return "ItemsObj{" +
                "item_type='" + item_type + '\'' +
                ", totalProfits=" + totalProfits +
                '}';
    }
}
