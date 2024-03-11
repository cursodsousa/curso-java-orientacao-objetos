package io.github.cursodsousa.cadastro.generic;

import java.util.ArrayList;
import java.util.List;

public abstract class Repositorio<TIPO> {

    private List<TIPO> lista = new ArrayList<>();

    public void adicionar(TIPO objeto){
        lista.add(objeto);
    }

    public void remover(TIPO objeto){
        lista.remove(objeto);
    }
}
