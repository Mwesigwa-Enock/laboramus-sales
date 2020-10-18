package com.laboramus.sales.payloads.responses;

import com.laboramus.sales.Objects.ItemsObj;
import com.laboramus.sales.Objects.SalesObj;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class SalesResponse implements Serializable {
    private BigDecimal totalProfit;
    private List<ItemsObj> itemsObjs;

    public BigDecimal getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(BigDecimal totalProfit) {
        this.totalProfit = totalProfit;
    }

    public List<ItemsObj> getItemsObjs() {
        return itemsObjs;
    }

    public void setItemsObjs(List<ItemsObj> itemsObjs) {
        this.itemsObjs = itemsObjs;
    }

    @Override
    public String toString() {
        return "SalesResponse{" +
                "totalProfit=" + totalProfit +
                ", itemsObjs=" + itemsObjs +
                '}';
    }
}
