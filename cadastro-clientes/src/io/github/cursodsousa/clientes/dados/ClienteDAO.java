package io.github.cursodsousa.clientes.dados;

import io.github.cursodsousa.clientes.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Cliente cliente){
        try {
            PreparedStatement comando = this.connection.prepareStatement("""
                insert into cliente (codigo, nome) values (?,?)     
            """);

            comando.setString(1, cliente.getCodigo().toString());
            comando.setString(2, cliente.getNome());

            comando.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
