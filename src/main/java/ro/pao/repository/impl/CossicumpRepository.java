package ro.pao.repository.impl;

import ro.pao.model.comanda.Cos;
import ro.pao.model.comanda.generics.cossicumpbd;
import ro.pao.model.cumparator.Sealedforcump;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CossicumpRepository {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String username = "postgres";
    private final String password = "root";

    private Connection connection;

    public CossicumpRepository() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
