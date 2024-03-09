package io.github.cursodsousa;

import java.time.LocalDateTime;

public interface Transferencia {

    LocalDateTime getDataHoraTransferencia();

    double getValorTransferencia();

    double calcularTaxa();

    int getNumeroContaDestino();

    String getTipo();

}
