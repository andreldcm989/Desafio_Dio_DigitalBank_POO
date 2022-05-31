package entities.services;

import java.util.Optional;

import entities.Conta;

public interface ContaService {
    
    void saque(double valor);
    void deposito(double valor);
    void transferencia(Optional<Conta> conta, double valor);
}
