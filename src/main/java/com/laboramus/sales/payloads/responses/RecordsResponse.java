package com.laboramus.sales.payloads.responses;

import java.io.Serializable;

public class RecordsResponse  implements Serializable {
    private String order_date , order_priority, item_type;
    private Integer sale_id, units_sold, unit_price,total_cost;

    public Integer getSale_id() {
        return sale_id;
    }

    public void setSale_id(Integer sale_id) {
        this.sale_id = sale_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_priority() {
        return order_priority;
    }

    public void setOrder_priority(String order_priority) {
        this.order_priority = order_priority;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public Integer getUnits_sold() {
        return units_sold;
    }

    public void setUnits_sold(Integer units_sold) {
        this.units_sold = units_sold;
    }

    public Integer getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Integer unit_price) {
        this.unit_price = unit_price;
    }

    public Integer getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(Integer total_cost) {
        this.total_cost = total_cost;
    }

    @Override
    public String toString() {
        return "RecordsResponse{" +
                "order_date='" + order_date + '\'' +
                ", order_priority='" + order_priority + '\'' +
                ", item_type='" + item_type + '\'' +
                ", sale_id=" + sale_id +
                ", units_sold=" + units_sold +
                ", unit_price=" + unit_price +
                ", total_cost=" + total_cost +
                '}';
    }
}
