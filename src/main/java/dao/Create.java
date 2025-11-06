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
                "NOME TEXT , " +
                "NASCIMENTO TEXT , " +
                "DOCUMENTO INTEGER, " +
                "CELULAR TEXT , " +
                "SEXO TEXT, " +
                "GRUPO TEXT, " +
                "DEL TEXT DEFAULT ' ' " +
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
