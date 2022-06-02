package com.revature.CapitalTwo.daos;

import com.revature.CapitalTwo.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DebitAccountDAO implements CrudDAO<DebitAccount>{
    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(DebitAccount obj) {
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO user (id, debitDeposit, debitWithdraw) VALUES (?, ?, ?)");
            ps.setString(1, obj.getId());
            ps.setInt(2, obj.getDebitDeposit());
            ps.setInt(3, obj.getDebitWithdraw());
            ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
    }
    @Override
    public void update(DebitAccount obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public DebitAccount getById(String id) {
        return null;
    }

    @Override
    public List<DebitAccount> getAll() {
        return null;
    }
}
