package entities;

public class CreditoImobiliario extends Produtos {

    private Double vlLiberado;
    private Double txMensal;

    public CreditoImobiliario() {
    }

    public CreditoImobiliario(Integer numParcelas, int vencimento, Conta conta) {
        super(numParcelas, vencimento, conta);
        setNome("Crédito Imobiliário");
        disponivel(conta.getCliente().getRenda(), numParcelas);
        vlLiberado = limite(conta.getCliente().getRenda(), numParcelas);
        txMensal =  juroMensal(conta.getCliente().getRenda());
    }

    public Double getVlLiberado() {
        return vlLiberado;
    }

    public Double getTxMensal() {
        return txMensal;
    }

    public double disponivel(Double renda, int parcelas){
        return (renda * 0.4) * parcelas;
    }

    public double limite(Double renda, int parcelas) {
        return disponivel(renda, parcelas) / (juroMensal(disponivel(renda, parcelas)) * parcelas);
    }

    public double juroMensal(Double vlSolicitado) {
        if(vlSolicitado < 120000.00) return 11.75 / 100;
        if(vlSolicitado < 200000.00) return 9.75 / 100;
        return 8.75 / 100 / 12; 
    }

    public void resumo(){
        informacoes();
        System.out.println("Valor liberado: R$ " + String.format("%.2f", vlLiberado));
        System.out.println("Juros mensais: " + String.format("0,00%", txMensal));
        System.out.println("Parcelamento: " + numParcelas + "x de R$ " + String.format("%.2f", vlLiberado/numParcelas));
    }
    
}
