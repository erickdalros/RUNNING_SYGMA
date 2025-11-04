package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {

    public void criarTabelaDefault(String nome) {

        nome = nome.replaceAll("[^a-zA-Z0-9_]", "");

        String query = "CREATE TABLE IF NOT EXISTS " + nome + " (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NUMERO INTEGER, " +
                "NOME TEXT NOT NULL, " +
                "NASCIMENTO TEXT NOT NULL, " +
                "DOCUMENTO INTEGER, " +
                "CELULAR TEXT NOT NULL, " +
                "SEXO TEXT NOT NULL, " +
                "GRUPO TEXT NOT NULL, " +
                "DEL TEXT NOT NULL DEFAULT ' ' " +
                ");";

        try (Connection conn = Config.abrirConexao()) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                stmt.executeQuery(query);
                System.out.println("Sucesso ao criar a tabela 'CORREDORES'");
            } else {
                System.out.println("Falha ao conectar ao banco");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
