package io.github.cursodsousa.clientes.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {

    private static String url = "jdbc:postgresql://localhost:5432/clientes";
    private static String senha = "postgres";
    private static String user = "postgres";

    public static Connection createConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, senha);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Erro ao obter conexão!");
        }
    }
}
