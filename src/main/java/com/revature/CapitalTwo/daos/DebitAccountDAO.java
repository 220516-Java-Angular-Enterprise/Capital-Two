package com.revature.CapitalTwo.daos;

import com.revature.CapitalTwo.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DebitAccountDAO implements CrudDAO<Debit_Account>{
    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(Debit_Account obj) {
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO user (id, debit_deposit, debit_withdraw) VALUES (?, ?, ?)");
            ps.setString(1, obj.get_Id());
            ps.setInt(2, obj.get_Debit_Deposit());
            ps.setInt(3, obj.get_Debit_Withdraw());
            ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
    }

    @Override
    public void update(Debit_Account obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Debit_Account getById(String id) {
        return null;
    }

    @Override
    public List<Debit_Account> getAll() {
        return null;
    }
}
