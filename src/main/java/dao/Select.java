package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Corredor;


public class Select {

    public List<String> nomeTabela = new ArrayList<>();

    public List<String> selectTabelas() {

        String sql = """
                SELECT TBL_NAME FROM sqlite_master WHERE type='table' AND TBL_NAME <> 'sqlite_sequence' ORDER BY TBL_NAME;
                """;

        try (Connection conn = Config.abrirConexao()) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet row = stmt.executeQuery(sql);
                while (row.next()) {
                    nomeTabela.add(row.getString("TBL_NAME"));
                    /*for(String nomes : nomeTabela) {
                        System.out.println(nomes);
                    }*/
                }

                System.out.println("Select das tabelas realizado com sucesso");
            } else {
                System.out.println("Erro ao executar o select");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nomeTabela;
    }




    public ArrayList<Corredor> listaCorredores(String tabela) {

        List<Corredor> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + tabela ;

        try (Connection conn = Config.abrirConexao()) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet row = stmt.executeQuery(sql);
                while (row.next()) {
                    Corredor corredor = new Corredor(
                        row.getString("ID"),
                        row.getString("NUMERO"),
                        row.getString("NOME"),
                        row.getString("NASCIMENTO"),
                        row.getString("DOCUMENTO"),
                        row.getString("CELULAR"),
                        row.getString("SEXO"),
                        row.getString("GRUPO"),
                        row.getString("DEL")
                    );
                    lista.add(corredor);
                }
                System.out.println("Select dos corredores da tabela " + tabela + " realizado com SUCESSO");
            } else {
                System.out.println("Erro ao executar o select");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<Corredor>) lista;
    }

}



