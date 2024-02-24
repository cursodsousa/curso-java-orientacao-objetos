package sistemabancario;

public class Conta {

    Cliente titular;
    int numero;
    double saldo;

    Conta(){}

    Conta(Cliente titular, int numero, double saldo){
        this.titular = titular;
        this.numero = numero;
        if(saldo >= 0){
            this.saldo = saldo;
        }
    }

    void imprimirSaldo(){
        System.out.println("Saldo atual para a conta " +
                this.numero + ": " + this.saldo);
    }
}
