package io.github.cursodsousa.clientes.logicanegocio;

import io.github.cursodsousa.clientes.dominio.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LogicaCadastroMemoria implements Cadastro<Cliente> {

    private List<Cliente> lista;

    public LogicaCadastroMemoria() {
        this.lista = new ArrayList<>();
    }

    @Override
    public void salvar(Cliente cliente) {
        this.lista.add(cliente);
    }

    @Override
    public Cliente buscar(UUID codigo) {

        Cliente clienteEncontrado = null;

        for (Cliente c : this.lista){
            if(c.getCodigo().equals(codigo)){
                clienteEncontrado = c;
                break;
            }
        }

        return clienteEncontrado;
    }

    @Override
    public void deletar(UUID codigo) {
        Cliente clienteEncontrado = this.buscar(codigo);
        if(clienteEncontrado != null){
            this.lista.remove(clienteEncontrado);
        }
    }

    @Override
    public void atualizar(Cliente cliente) {
        // faz sentido ao trabalhar com banco de dados
    }

    @Override
    public void imprimirRegistros() {
        System.out.println("Imprimindo " + this.lista.size() + " clientes:");
        for (Cliente cliente : this.lista ){
            System.out.println(cliente);
        }
    }
}
