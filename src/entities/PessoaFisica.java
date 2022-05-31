package entities;

import java.time.LocalDate;

public class PessoaFisica extends Cliente {

    private String cpf;
    private LocalDate dtNasc;
    

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(String nome, String email, String telefone, String tipoCliente, Double renda, String cpf,
            LocalDate dtNasc) {
        super(nome, email, telefone, tipoCliente, renda);
        this.cpf = cpf;
        this.dtNasc = dtNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDtNasc() {
        return dtNasc;
    }

}
