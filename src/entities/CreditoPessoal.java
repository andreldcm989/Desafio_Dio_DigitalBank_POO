package entities;

public class CreditoPessoal extends Produtos {

    public CreditoPessoal(){
        super.setNome("Crédito Pessoal");
    }
    
    public double limite(Double renda, int parcelas){
        return (renda * 0.30) * 10;
    }

    public double juroMensal(Double vlSolicitado) {
        if(vlSolicitado < 10000.00) return 4.99/100;
        if(vlSolicitado < 20000.00) return 3.99/100;
        if(vlSolicitado < 30000.00) return 2.99/100; 
        return 1.99/100;
    }
}
