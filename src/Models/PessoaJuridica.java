package Models;

public class PessoaJuridica {
    String nome;
    int pos;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, int pos) {
        this.nome = nome;
        this.pos = pos;
    }

    public String getNome() {
        return nome;
    }

    public int getPos() {
        return pos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "nome='" + nome + '\'' +
                ", pos=" + pos +
                '}';
    }

    public String ticket() {
        return  "|"+"------------------------------\n"+
                "|"+ "       Receita Federal       \n"+
                "|"+"       Pessoa Juridica          \n"+
                "|"+" nome: " + nome +"            \n"+
                "|"+"Posição na Fila=" + pos+"     \n"+
                "|"+"-------------------------------"
                ;
    }
}
