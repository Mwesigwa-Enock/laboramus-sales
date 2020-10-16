package com.laboramus.sales.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class SalesObj implements Serializable {
    private String Region, Country, Item_type, Sales_Channel,Order_Priority,	Order_Date,	Order_ID,
    Ship_Date;
    private int Units_Sold, sale_id;
    private BigDecimal Unit_Price, Unit_Cost, Total_Revenue, Total_Cost,	Total_Profit;

    public int getSale_id() {
        return sale_id;
    }

    public void setSale_id(int sale_id) {
        this.sale_id = sale_id;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getItem_type() {
        return Item_type;
    }

    public void setItem_type(String item_type) {
        Item_type = item_type;
    }

    public String getSales_Channel() {
        return Sales_Channel;
    }

    public void setSales_Channel(String sales_Channel) {
        Sales_Channel = sales_Channel;
    }

    public String getOrder_Priority() {
        return Order_Priority;
    }

    public void setOrder_Priority(String order_Priority) {
        Order_Priority = order_Priority;
    }

    public String getOrder_Date() {
        return Order_Date;
    }

    public void setOrder_Date(String order_Date) {
        Order_Date = order_Date;
    }

    public String getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(String order_ID) {
        Order_ID = order_ID;
    }

    public String getShip_Date() {
        return Ship_Date;
    }

    public void setShip_Date(String ship_Date) {
        Ship_Date = ship_Date;
    }

    public int getUnits_Sold() {
        return Units_Sold;
    }

    public void setUnits_Sold(int units_Sold) {
        Units_Sold = units_Sold;
    }

    public BigDecimal getUnit_Price() {
        return Unit_Price;
    }

    public void setUnit_Price(BigDecimal unit_Price) {
        Unit_Price = unit_Price;
    }

    public BigDecimal getUnit_Cost() {
        return Unit_Cost;
    }

    public void setUnit_Cost(BigDecimal unit_Cost) {
        Unit_Cost = unit_Cost;
    }

    public BigDecimal getTotal_Revenue() {
        return Total_Revenue;
    }

    public void setTotal_Revenue(BigDecimal total_Revenue) {
        Total_Revenue = total_Revenue;
    }

    public BigDecimal getTotal_Cost() {
        return Total_Cost;
    }

    public void setTotal_Cost(BigDecimal total_Cost) {
        Total_Cost = total_Cost;
    }

    public BigDecimal getTotal_Profit() {
        return Total_Profit;
    }

    public void setTotal_Profit(BigDecimal total_Profit) {
        Total_Profit = total_Profit;
    }

    @Override
    public String toString() {
        return "SalesObj{" +
                "Region='" + Region + '\'' +
                ", Country='" + Country + '\'' +
                ", Item_type='" + Item_type + '\'' +
                ", Sales_Channel='" + Sales_Channel + '\'' +
                ", Order_Priority='" + Order_Priority + '\'' +
                ", Order_Date='" + Order_Date + '\'' +
                ", Order_ID='" + Order_ID + '\'' +
                ", Ship_Date='" + Ship_Date + '\'' +
                ", Units_Sold=" + Units_Sold +
                ", sale_id=" + sale_id +
                ", Unit_Price=" + Unit_Price +
                ", Unit_Cost=" + Unit_Cost +
                ", Total_Revenue=" + Total_Revenue +
                ", Total_Cost=" + Total_Cost +
                ", Total_Profit=" + Total_Profit +
                '}';
    }
}
