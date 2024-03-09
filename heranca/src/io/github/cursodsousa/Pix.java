package io.github.cursodsousa;

import java.time.LocalDateTime;

public class Pix implements Transferencia {

    private double valorTransferencia;
    private int numeroContaDestino;

    public Pix(double valorTransferencia, int numeroContaDestino) {
        this.valorTransferencia = valorTransferencia;
        this.numeroContaDestino = numeroContaDestino;
    }

    @Override
    public LocalDateTime getDataHoraTransferencia() {
        return LocalDateTime.now();
    }

    @Override
    public double getValorTransferencia() {
        return this.valorTransferencia;
    }

    @Override
    public double calcularTaxa() {
        return 0;
    }

    @Override
    public int getNumeroContaDestino() {
        return this.numeroContaDestino;
    }

    @Override
    public String getTipo() {
        return "PIX";
    }
}
