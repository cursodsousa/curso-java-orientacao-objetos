package io.github.cursodsousa.clientes.dados;

import io.github.cursodsousa.clientes.dominio.Cliente;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Maria");

        Connection connection = FabricaConexoes.createConnection();
        ClienteDAO clienteDAO = new ClienteDAO(connection);

        clienteDAO.inserir(cliente);
    }
}
