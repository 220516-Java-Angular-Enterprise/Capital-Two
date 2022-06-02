package com.revature.CapitalTwo.daos;

import com.revature.CapitalTwo.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LoanAccountDAO implements CrudDAO<Loan_Account>{
    Connection con = DatabaseConnection.getCon();


    @Override
    public void save(Loan_Account obj) {
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO user (id, loan_amount, loan_history_id) VALUES (?, ?, ?)");
            ps.setString(1, obj.get_Id());
            ps.setInt(2, obj.get_Loan_Amount());
            ps.setString(3, obj.get_Loan_History_Id());
            ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
    }

    @Override
    public void update(Loan_Account obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Loan_Account getById(String id) {
        return null;
    }

    @Override
    public List<Loan_Account> getAll() {
        return null;
    }
}
