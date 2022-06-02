package com.revature.CapitalTwo.daos;

import com.revature.CapitalTwo.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BankAccountDAO implements CrudDAO<BankAccount>{
    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(BankAccount obj) {
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO user (id, debit_id, credit_id, user_id, loan_id) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, obj.getId());
            ps.setString(2, obj.getDebitId());
            ps.setString(3, obj.getCreditId());
            ps.setString(4, obj.getUserId());
            ps.setString(5, obj.getLoanId());
            ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
    }

    @Override
    public void update(BankAccount obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public BankAccount getById(String id) {
        return null;
    }

    @Override
    public List<BankAccount> getAll() {
        return null;
    }
}
