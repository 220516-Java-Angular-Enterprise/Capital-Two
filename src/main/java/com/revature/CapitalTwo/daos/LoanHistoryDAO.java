package com.revature.CapitalTwo.daos;

import com.revature.CapitalTwo.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LoanHistoryDAO implements CrudDAO<Loan_History>{
    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(Loan_History obj) {
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO user (id, date, action, amount) VALUES (?, ?, ?, ?,)");
            ps.setString(1, obj.getId());
            ps.setString(2, obj.getDate());
            ps.setString(3, obj.getAction());
            ps.setInt(4, obj.getAmount());
            ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
    }

    @Override
    public void update(Loan_History obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Loan_History getById(String id) {
        return null;
    }

    @Override
    public List<Loan_History> getAll() {
        return null;
    }

}
