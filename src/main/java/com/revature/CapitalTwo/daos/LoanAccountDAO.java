package com.revature.CapitalTwo.daos;

import com.revature.CapitalTwo.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LoanAccountDAO implements CrudDAO<LoanAccount>{
    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(LoanAccount obj) {
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO user (id, loanAmount, loanHistoryId) VALUES (?, ?, ?)");
            ps.setString(1, obj.getId());
            ps.setInt(2, obj.getLoanAmount());
            ps.setString(3, obj.getLoanHistoryId());
            ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
    }

    @Override
    public void update(LoanAccount obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public LoanAccount getById(String id) {
        return null;
    }

    @Override
    public List<LoanAccount> getAll() {
        return null;
    }

}
