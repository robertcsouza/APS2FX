package Models;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

public class PessoaFisica {
    String nome;
    int pos;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, int pos) {
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


    @Override
    public String toString() {
        return "PessoaFisica{" +
                "nome='" + nome + '\'' +
                ", pos=" + pos +
                '}';
    }

    public Map toMap(){

        Map<String, String> map = new HashMap<String, String>();
        map.put("nome",nome);
        map.put("pos",String.valueOf(pos));
        return map;
    }

    public String ticket() {
        return  "|"+"------------------------------\n"+
                "|"+ "       Receita Federal       \n"+
                "|"+"       Pessoa Fisica          \n"+
                "|"+" nome: " + nome +"            \n"+
                "|"+"Posição na Fila=" + pos+"     \n"+
                "|"+"-------------------------------"
                ;
    }
}
