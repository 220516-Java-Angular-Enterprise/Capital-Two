package com.revature.CapitalTwo.daos;

import com.revature.CapitalTwo.models.User;
import com.revature.CapitalTwo.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userDAO implements CrudeDAO<User>{

    Connection con = DatabaseConnection.getCon();
    @Override
    public void save(User obj) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (id, username, password, annual_sal, address, state, name) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, obj.getId());
            ps.setString(2, obj.getUsername());
            ps.setString(3, obj.getPassword());
            ps.setInt(4, obj.getAnnual_sal());
            ps.setString(5, obj.getAddress());
            ps.setString(6, obj.getState());
            ps.setString(7, obj.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

    }

    @Override
    public void update(User Obj) {
        try{
            PreparedStatement ps = con.prepareStatement("UPDATE users SET " +
                    "password = '" + Obj.getPassword() + "'," +
                    "annual_sal = '" + Obj.getAnnual_sal() + "'," +
                    "address = '" + Obj.getAddress() + "'," +
                    "state = '" + Obj.getState() + "'," +
                    "name = '" + Obj.getName() + "' " +
                    "WHERE id = '" + Obj.getId() + "';");
            ps.executeUpdate();
        }   catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public User getByID(String id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                User user = new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("id"),
                        rs.getInt("annual_sal"),
                        rs.getString("address"),
                        rs.getString("state")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return users;
    }


    public List<String> getAllUsernames() {
        List<String> usernames = new ArrayList();

        try {
            PreparedStatement ps = con.prepareStatement("Select username FROM users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                usernames.add(rs.getString("username"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("n error occurred when tyring to get data from to the database.");
        }
        return usernames;
    }
}
