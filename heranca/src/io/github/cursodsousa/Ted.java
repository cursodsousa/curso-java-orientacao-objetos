package io.github.cursodsousa;

import java.time.LocalDateTime;

public class Ted implements Transferencia {

    private double valorTransferencia;
    private int numeroContaDestino;

    public Ted(double valorTransferencia, int numeroContaDestino) {
        this.valorTransferencia = valorTransferencia;
        this.numeroContaDestino = numeroContaDestino;
    }

    @Override
    public double getValorTransferencia() {
        return valorTransferencia;
    }

    @Override
    public LocalDateTime getDataHoraTransferencia() {
        return LocalDateTime.now().plusHours(1);
    }

    @Override
    public double calcularTaxa() {
        return 10d;
    }

    @Override
    public int getNumeroContaDestino() {
        return numeroContaDestino;
    }

    @Override
    public String getTipo() {
        return "TED";
    }
}
