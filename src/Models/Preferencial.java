package Models;

public class Preferencial {
    String nome;
    int pos;

    public Preferencial() {
    }

    public Preferencial(String nome, int pos) {
        this.nome = nome;
        this.pos = pos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "Preferencial{" +
                "nome='" + nome + '\'' +
                ", pos=" + pos +
                '}';
    }

    public String ticket() {
        return  "|"+"------------------------------\n"+
                "|"+ "       Receita Federal       \n"+
                "|"+"        Preferencial          \n"+
                "|"+" nome: " + nome +"            \n"+
                "|"+"Posição na Fila=" + pos+"     \n"+
                "|"+"-------------------------------"
                ;
    }
}
