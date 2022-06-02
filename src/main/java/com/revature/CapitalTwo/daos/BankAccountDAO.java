package com.revature.CapitalTwo.daos;

import com.revature.CapitalTwo.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDAO implements CrudDAO<Bank_Account>{
    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(Bank_Account obj) {
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO user (id, debit_id, credit_id, user_id, loan_id) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, obj.getId());
            ps.setString(2, obj.getDebit_Id());
            ps.setString(3, obj.getCredit_Id());
            ps.setString(4, obj.getUser_Id());
            ps.setString(5, obj.getLoan_Id());
            ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
    }
    @Override
    public void update(Bank_Account obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Bank_Account getById(String id) {
        return null;
    }

    @Override
    public List<Bank_Account> getAll() {
        return null;
    }
}
