package Classes;

public class ContaBancaria {
	
	private double saldo;
    private Cliente cliente;
    private String numeroConta;

    public ContaBancaria(Cliente cliente, String numeroConta) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = 0.00;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado com sucesso. Saldo atual: "+ String.format("%.2f", saldo));
    }

    public void sacar(double valor) {
        double valorComTaxa = valor * 1.05;
        if (valor > 500) {
            System.out.println("O limite de saque é de R$500,00.");
        } else if (saldo >= valorComTaxa) {
            saldo -= valorComTaxa;
            System.out.println("Saque realizado com sucesso. Saldo atual: " + String.format("%.2f",saldo));
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }

    public void transferir(ContaBancaria contaDestino, double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada com sucesso. Saldo atual: " + String.format("%.2f",saldo));
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}


