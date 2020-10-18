package com.laboramus.sales.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class AnalyticsObj implements Serializable {
    private int countries, itemTypes, regions;
    private BigDecimal totalProfits;

    public int getCountries() {
        return countries;
    }

    public void setCountries(int countries) {
        this.countries = countries;
    }

    public int getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(int itemTypes) {
        this.itemTypes = itemTypes;
    }

    public int getRegions() {
        return regions;
    }

    public void setRegions(int regions) {
        this.regions = regions;
    }

    public BigDecimal getTotalProfits() {
        return totalProfits;
    }

    public void setTotalProfits(BigDecimal totalProfits) {
        this.totalProfits = totalProfits;
    }

    @Override
    public String toString() {
        return "AnalyticsObj{" +
                "countries=" + countries +
                ", itemTypes=" + itemTypes +
                ", regions=" + regions +
                ", totalProfits=" + totalProfits +
                '}';
    }
}
