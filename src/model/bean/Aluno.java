package model.bean;

public class Aluno {
    private int ra, id;
    private String nome, previsaoFormatura;

    public Aluno() {
    }

    
    
    // Construtores
    public Aluno(int ra, String nome, String previsaoFormatura) {
        this.ra = ra;
        this.nome = nome;
        this.previsaoFormatura = previsaoFormatura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Get & Set
    public int getRa() {
        return ra;
    }
    public void setRa(int ra) {
        this.ra = ra;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPrevisaoFormatura() {
        return previsaoFormatura;
    }
    public void setPrevisaoFormatura(String previsaoFormatura) {
        this.previsaoFormatura = previsaoFormatura;
    }
    
}
