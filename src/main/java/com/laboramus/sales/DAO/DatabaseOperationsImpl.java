package com.laboramus.sales.DAO;

import com.laboramus.sales.Objects.SalesObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class DatabaseOperationsImpl implements DatabaseOperations {

    @Autowired
    private JdbcTemplate jdbctemplate;

    public DatabaseOperationsImpl(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }


    @Transactional
    @Override
    public int[] batchInsertSales(List<SalesObj> salesObjList) {

        return this.jdbctemplate.batchUpdate("INSERT INTO sales (region, country, item_type, sales_channel, order_priority," +
                " order_date, order_id, ship_date, units_sold, unit_price, unit_cost, total_revenue, total_cost, total_profit) " +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, salesObjList.get(i).getRegion());
                        ps.setString(2, salesObjList.get(i).getCountry());
                        ps.setString(3, salesObjList.get(i).getItem_type());
                        ps.setString(4, salesObjList.get(i).getSales_Channel());
                        ps.setString(5, salesObjList.get(i).getOrder_Priority());
                        ps.setString(6, salesObjList.get(i).getOrder_Date());
                        ps.setString(7, salesObjList.get(i).getOrder_ID());
                        ps.setString(8, salesObjList.get(i).getShip_Date());
                        ps.setInt(9, salesObjList.get(i).getUnits_Sold());
                        ps.setBigDecimal(10, salesObjList.get(i).getUnit_Price());
                        ps.setBigDecimal(11, salesObjList.get(i).getUnit_Cost());
                        ps.setBigDecimal(12, salesObjList.get(i).getTotal_Revenue());
                        ps.setBigDecimal(13, salesObjList.get(i).getTotal_Cost());
                        ps.setBigDecimal(14, salesObjList.get(i).getTotal_Profit());
                    }

                    @Override
                    public int getBatchSize() {
                        return salesObjList.size();
                    }
                }
        );

    }
}
