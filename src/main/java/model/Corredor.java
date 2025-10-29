package model;

public class Corredor {

    private String nome;
    private  String idade;
    private  String modalidade;

    public Corredor(){

    }

    public Corredor(String nome, String idade, String modalidade){
        this.nome = nome;
        this.idade = idade;
        this.modalidade = modalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    @Override
    public String toString() {
        return "Corredor{" + "nome=" + nome + ", idade=" + idade + modalidade + " + modalidade + '}'";
    }



}