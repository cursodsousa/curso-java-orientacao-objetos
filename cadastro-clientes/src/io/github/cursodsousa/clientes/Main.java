package io.github.cursodsousa.clientes;

import io.github.cursodsousa.clientes.dominio.Cliente;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        System.out.println(cliente.getCodigo());
    }
}
