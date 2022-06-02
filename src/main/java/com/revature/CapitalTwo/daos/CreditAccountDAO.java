package com.revature.CapitalTwo.daos;

import com.revature.CapitalTwo.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CreditAccountDAO implements CrudDAO<Credit_Account>{
    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(Credit_Account obj) {
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO user (id, credit_balance, credit_withdraw, debit_id) VALUES (?, ?, ?, ?)");
            ps.setString(1, obj.get_Id());
            ps.setString(2, obj.get_Credit_Balance());
            ps.setString(3, obj.get_Credit_Withdraw());
            ps.setString(4, obj.get_Debit_Id());
            ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
    }

    @Override
    public void update(Credit_Account obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Credit_Account getById(String id) {
        return null;
    }

    @Override
    public List<Credit_Account> getAll() {
        return null;
    }
}
