package entities;

public abstract class Cliente {
    private static int ID_CLIENTE = 1;

    protected int id;
    protected String nome;
    protected String email;
    protected String telefone;
    protected String tipoCliente;
    protected Double renda;

    protected Conta conta;

    public Cliente(){
    }

    public Cliente(String nome, String email, String telefone, String tipoCliente, Double renda) {
        id = ID_CLIENTE++;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipoCliente = tipoCliente;
        this.renda = renda;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
}
