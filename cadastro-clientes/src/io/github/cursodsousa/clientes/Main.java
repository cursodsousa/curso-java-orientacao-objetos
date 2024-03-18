package io.github.cursodsousa.clientes;

import io.github.cursodsousa.clientes.apresentacao.TelaCadastro;
import io.github.cursodsousa.clientes.dominio.Cliente;
import io.github.cursodsousa.clientes.logicanegocio.Cadastro;

public class Main {
    public static void main(String[] args) {
        TelaCadastro telaCadastro = new TelaCadastro();
        telaCadastro.setVisible(true);
    }
}
