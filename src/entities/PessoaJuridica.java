package entities;

public class PessoaJuridica extends Cliente {

    private String cnpj;

    public PessoaJuridica() {
        super();
    }

    

    public PessoaJuridica(String nome, String email, String telefone, String tipoCliente, Double renda, String cnpj) {
        super(nome, email, telefone, tipoCliente, renda);
        this.cnpj = cnpj;
    }



    public String getCnpj() {
        return cnpj;
    }

}
