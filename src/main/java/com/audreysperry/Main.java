package com.audreysperry;

import com.audreysperry.helpers.DatabaseManager;
import com.audreysperry.models.Stat;

import java.sql.*;
import java.util.ArrayList;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:stats.db")) {

            DatabaseManager dbm = new DatabaseManager(conn);

            dbm.dropStatTable();
            dbm.createStatTable();
            dbm.insertIntoStatTable("Audrey", 100, 40);
            ArrayList<Stat> results = dbm.getStats();


        } catch(SQLException ex) {
            out.println("We encountered a problem connecting to the database.");
        }


        out.println("It works");
    }
}
