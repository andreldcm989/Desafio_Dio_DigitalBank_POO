package entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import entities.services.ProdutosService;

public abstract class Produtos implements ProdutosService{
    private static int ID_PRODUTO =  1;

    protected int id;
    protected String nome;
    protected Integer numParcelas;
    protected int vencimento;
    protected Conta conta;
    protected Map<LocalDate, Double> contrato = new HashMap<>();

    public Produtos() {
    }

    public Produtos(Integer numParcelas, int vencimento, Conta conta) {
        this.id = ID_PRODUTO++;
        this.numParcelas = numParcelas;
        this.vencimento = vencimento;
        this.conta = conta;
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getNumParcelas() {
        return numParcelas;
    }
    public void setNumParcelas(Integer numParcelas) {
        this.numParcelas = numParcelas;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Map<LocalDate, Double> getContrato() {
        return contrato;
    }

    public void geraParcelas(int dia, int numParcelas, double valor){
        double vlParcela = valor / numParcelas;
        LocalDate hj = LocalDate.now();
        for(int i = 1; i <= numParcelas; i++){
            contrato.put(LocalDate.of(hj.getYear(), hj.getMonthValue(), dia).plusMonths(i), vlParcela);
        }
    }
    
    public void informacoes(){
        System.out.println("Contrato: " + id);
        System.out.println("Produto: " + nome);
        System.out.println("Numero de parcelas: " + numParcelas);
        System.out.println("Vencimento: ");
    }

    
}
