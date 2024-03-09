package io.github.cursodsousa;

public class Main {
    public static void main(String[] args) {
        OperadorBancario operadorBancario = new OperadorBancario();

        Transferencia pix = new Pix(50, 1234);
        operadorBancario.realizarTransferencia(pix);

        Transferencia ted = new Ted(1000, 1234);
        operadorBancario.realizarTransferencia(ted);
    }
}
