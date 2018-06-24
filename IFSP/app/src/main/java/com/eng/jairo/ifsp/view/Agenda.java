//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: José Maria Jairo Chaves

//******************************************************


package com.eng.jairo.ifsp.view;
// OBJETIVO.......: Classe Agenda
public class Agenda {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private int idade;
// OBJETIVO.......: Método principal da classe Agenda, que inicializa todos os dados
    public Agenda(String nome, String cpf, String telefone, String email, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.idade = idade;
    }
// OBJETIVO.......: Métodos Geters e Seters
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
