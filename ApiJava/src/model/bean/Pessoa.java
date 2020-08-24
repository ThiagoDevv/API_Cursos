package model.bean;


public class Pessoa {
    private int IdPessoa;
    private String nome;
    private String cpf;

    public int getIdPessoa() {
        return IdPessoa;
    }

    public void setIdPessoa(int IdPessoa) {
        this.IdPessoa = IdPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
