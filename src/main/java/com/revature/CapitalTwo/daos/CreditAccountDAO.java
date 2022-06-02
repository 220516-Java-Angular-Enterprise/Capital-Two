package com.revature.CapitalTwo.daos;

import com.revature.CapitalTwo.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CreditAccountDAO implements CrudDAO<CreditAccount>{
    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(CreditAccount obj) {
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO user (id, creditBalance, creditWithdraw, debitId) VALUES (?, ?, ?, ?)");
            ps.setString(1, obj.getId());
            ps.setString(2, obj.getCreditBalance());
            ps.setString(3, obj.getCreditWithdraw());
            ps.setString(4, obj.getDebitId());
            ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
    }

    @Override
    public void update(CreditAccount obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public CreditAccount getById(String id) {
        return null;
    }

    @Override
    public List<CreditAccount> getAll() {
        return null;
    }
}
