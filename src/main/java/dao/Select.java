package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Select {

    public List<String> nomeTabela = new ArrayList<>();

    public List<String> selectTabelas() {

        String sql = """
                SELECT TBL_NAME FROM sqlite_master WHERE type='table' AND TBL_NAME <> 'sqlite_sequence';
                """;

        try (Connection conn = Config.abrirConexao()) {
            if(conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet row = stmt.executeQuery(sql);
                while(row.next()) {
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

}
