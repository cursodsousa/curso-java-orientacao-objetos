package io.github.cursodsousa;

import java.time.LocalDateTime;

public class OperadorBancario {

    public void realizarTransferencia(Transferencia transferencia){
        int contaDestino = transferencia.getNumeroContaDestino();
        realizarCobranca(contaDestino, transferencia.calcularTaxa(), transferencia.getTipo());
        agendarPagamento(transferencia.getDataHoraTransferencia(),
                contaDestino, transferencia.getValorTransferencia(), transferencia.getTipo());
    }

    public void realizarCobranca(int conta, double valor, String tipo){
        System.out.println("Foi cobrado o valor de $ " + valor +" da conta " + conta + " pelo " + tipo);
    }

    public void agendarPagamento(LocalDateTime dataHora, int conta, double valor, String tipo){
        System.out.println(tipo + " para conta " + conta +
                ", no valor de " + valor + " agendado para " + dataHora);
    }
}
