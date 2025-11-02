package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Config {

    String url = "src/main/java/data";

    try (Connection conn = DriverManager.getConnection(url);
    Statement stmt = conn.createStatement()) {

    } catch (
    SQLException e) {
        e.printStackTrace();
    }
}
