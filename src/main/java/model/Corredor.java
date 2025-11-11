package model;

public class Corredor {

    private String id;
    private String numero;
    private String nome;
    private String nascimento;
    private String documento;
    private String celular;
    private String sexo;
    private String grupo;
    private String del;

    public Corredor(String id, String numero, String nome, String nascimento, String documento,
                     String celular, String sexo, String grupo, String del) {
        this.id = id;
        this.numero = numero;
        this.nome = nome;
        this.nascimento = nascimento;
        this.documento = documento;
        this.celular = celular;
        this.sexo = sexo;
        this.grupo = grupo;
        this.del = del;


    }

    public String getId() {
        return id;
    }
    public String getNumero() {
        return numero;
    }
    public String getNome() {
        return nome;
    }
    public String getNascimento() {
        return nascimento;
    }
    public String getDocumento() {
        return documento;
    }
    public String getCelular() {
        return celular;
    }
    public String getSexo() {
        return sexo;
    }
    public String getGrupo() {
        return grupo;
    }
    public String getDel() {
        return del;
    }

}
