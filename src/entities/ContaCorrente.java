package entities;

import java.util.Optional;

public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void saque(double valor) {
        saldo -= valor + (valor * 0.02);
    }

    @Override
    public void deposito(double valor) {
        saldo += valor;
    }

    @Override
    public void transferencia(Optional<Conta> conta, double valor) {
        saldo -= valor;
        conta.get().saldo += valor;
    }
    
}
