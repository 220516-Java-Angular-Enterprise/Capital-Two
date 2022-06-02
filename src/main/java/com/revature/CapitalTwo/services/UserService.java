package com.revature.CapitalTwo.services;

import com.revature.CapitalTwo.models.User;
import com.revature.CapitalTwo.util.custom_exceptions.InvalidAddressException;
import com.revature.CapitalTwo.util.custom_exceptions.InvalidPaswordException;
import com.revature.CapitalTwo.util.custom_exceptions.InvalidStateException;
import com.revature.CapitalTwo.util.custom_exceptions.InvalidUserException;

import java.util.List;

public class UserService {
    private final com.revature.CapitalTwo.daos.userDAO userDAO;

    public UserService(com.revature.CapitalTwo.daos.userDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void register(User user){
        userDAO.save(user);
    }

    public User login(String username, String password){
        User user = new User();
        List<User> users = userDAO.getAll();

        for (User u: users){
            if (u.getUsername().equals(username)){
                user.setId(u.getId());
                user.setUsername(u.getUsername());
                if (u.getPassword().equals(password)){
                    user.setPassword((u.getPassword()));
                    user.setAnnual_sal(u.getAnnual_sal());
                    user.setAddress(u.getAddress());
                    user.setState(u.getState());
                    user.setName(u.getName());
                    break;
                }
            }
            if (u.getPassword().equals(password)){
                user.setPassword(u.getPassword());
            }
        }
        return isValidCredentials(user);
    }

    public boolean isValidAddress(String address){
        if (address.matches("^(\\d+) ?([A-Za-z](?= ))? (.*?) ([^ ]+?) ?((?<= )APT)? ?((?<= )\\d*)?$")) {
            return true;
        } else {
            throw new InvalidAddressException("Invalid address entered. Example Format: 1111 Some Ln or 1111 Some Lane St");
        }
    }

    public boolean isValidPassWord(String password){
        if (password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")) {
            return true;
        } else {
            throw new InvalidPaswordException("Minimum eight characters, at least one letter, one number and one special character");
        }
    }

    public boolean isValidUsername(String username){
        if (username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$")){
            return true;
        } else {
            throw new InvalidUserException("Invalid username. Try another one.");
        }
    }
    public boolean isNotDuplicateUsername(String username){
        List<String> usernames = userDAO.getAllUsernames();
        if (usernames.contains(username)) throw new InvalidUserException("Email already exists.");
        return true;
    }
    public boolean isValidState(String state){
        if (state.matches("^((A[ELKSZR])|(C[AOT])|(D[EC])|(F[ML])|(G[AU])|(HI)|(I[DLNA])|(K[SY])|(LA)|(M[EHDAINSOT])|(N[EVHJMYCD])|(MP)|(O[HKR])|(P[WAR])|(RI)|(S[CD])|(T[NX])|(UT)|(V[TIA])|(W[AVIY]))$")) {
            return true;
        } else {
            throw new InvalidStateException("Invalid state entered.");
        }
    }

    public void update(User user){
        userDAO.update(user);
    }
    public User getUserByID(String id){
        return userDAO.getByID(id);
    }

    public User isValidCredentials(User user){
        if (user.getUsername() == null && user.getPassword() == null){
            throw new InvalidUserException("Incorrect username and password.");
        } else if (user.getUsername() == null) {
            throw new InvalidUserException("The username you entered does not exist.");
        } else if (user.getPassword() == null){
            throw new InvalidPaswordException("The password you entered does not match the username.");
        }
        return user;
    }
}
