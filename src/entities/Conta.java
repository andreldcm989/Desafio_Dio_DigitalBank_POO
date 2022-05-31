package entities;

import java.util.ArrayList;
import java.util.List;

import entities.services.ContaService;

public abstract class Conta implements ContaService{
    private static final int ID_AGENCIA = 1;
    private static int ID_CONTA = 1;

    protected int agencia;
    protected int numero;
    protected Double saldo;

    protected Cliente cliente;

    List<Produtos> produtos = new ArrayList<>();

    public Conta(Cliente cliente){
        agencia = ID_AGENCIA;
        numero = ID_CONTA++;
        this.cliente = cliente;
        saldo = 0.0;
    }


    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void addProduto(Produtos produto){
        produtos.add(produto);
    }

    public void removeProduto(Produtos produto){
        produtos.remove(produto);
    }
    
    public void infoConta(){
        System.out.println("Agência: " + agencia);
        System.out.println("Conta: " + numero);
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("Saldo: " + String.format("%.2f", saldo));
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numero;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        if (numero != other.numero)
            return false;
        return true;
    }

    
}
