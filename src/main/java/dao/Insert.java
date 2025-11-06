package dao;

import dao.Config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

    Config cfg = new Config();

    private int numero;
    private String nome;
    private int nascimento;
    private int documento;
    private String email;
    private int celular;
    public String nomeBanco;

    public void insertCorredor(int numero, String nome, String nascimento, int documento, String celular, String sexo, String nomeBanco) {


        String sql = "INSERT INTO " + nomeBanco +
                " (NUMERO, NOME, NASCIMENTO, DOCUMENTO, CELULAR, SEXO) " +
                " VALUES (?, ?, ?, ?, ?, ?) ;";

        try (Connection conn = Config.abrirConexao()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, numero);
            stmt.setString(2, nome);
            stmt.setString(3, nascimento);
            stmt.setInt(4, documento);
            stmt.setString(5, celular);
            stmt.setString(6, sexo);
            stmt.executeUpdate();
            System.out.println("Corredor adicionado com sucesso");
        } catch (SQLException e ) {
            e.printStackTrace();
        }


    }


}
