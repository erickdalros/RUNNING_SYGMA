package dao;
import controller.VerificarBancoDeDadosController;

public class CriarTabelaCorredoresDefault {

    String pastaRelativa = "src/main/java/data";

    String url = "jdbc:mysql:" + pastaRelativa;

    sql = """CREATE TABLE SYGMA_CORREDORESDEFAULT(" +
            "ID INTEGER AUTOINCREMENT PRIMARY KEY," +
            "NUMERO TEXT NOT NULL," +
            "NOME TEXT NOT NULL," +
            "DATA DATE," +
            "DOCUMENTO TEXT NOT NULL," +
            "EMAIL TEXT NOT NULL," +
            "CELULAR TEXT NOT NULL," +
            ");""";


}
