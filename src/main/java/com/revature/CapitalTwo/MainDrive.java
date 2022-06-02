package com.revature.CapitalTwo;

import com.revature.CapitalTwo.util.DatabaseConnection;

public class MainDrive {
    public static void main(String[] args) {
        System.out.println(DatabaseConnection.getCon());
    }
}

