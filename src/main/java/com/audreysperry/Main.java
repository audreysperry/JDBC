package com.audreysperry;

import java.sql.*;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:stats.db")) {
            // CREATE TABLE stats (id INTEGER PRIMARY KEY, name STRING, wins INTEGER, losses INTEGER)
            Statement statement = conn.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS stats;");
            statement.executeUpdate("CREATE TABLE stats (id INTEGER PRIMARY KEY, name STRING, wins INTEGER, losses INTEGER);");
            statement.executeUpdate("INSERT INTO stats (name, wins, losses) VALUES ('audrey', 10, 4);");
            ResultSet rs = statement.executeQuery("SELECT * FROM stats;");

            while (rs.next()) {
                String name = rs.getString("name");
                int wins = rs.getInt("wins");
                int losses = rs.getInt("losses");

                System.out.printf("%s %s %s\n", name, wins, losses);
            }

        } catch(SQLException ex) {
            out.println("We encountered a problem connecting to the database.");
        }


        out.println("It works");
    }
}
