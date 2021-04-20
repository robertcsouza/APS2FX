package sample;

import Models.Person;
import Models.PessoaFisica;
import Models.PessoaJuridica;
import Models.Preferencial;
import Stack.Queue;

import java.util.Scanner;

public class Engine {
   //input teclado
    Scanner scanner = null;

    //controle do switch
    int choose;

    //listas
    Queue pessoaJuridica = null;
    Queue pessoaFisica = null;
    Queue preferencial = null;
    Queue chamados = null;

    //controle de senha
    int pfLast = 0;
    int pjLast = 0;
    int ppLast = 0;

    //controle de chamada
    int pfc = 0;
    int pjc = 0;
    int ppc = 0;



    public Engine() {
        pessoaJuridica = new Queue();
        pessoaFisica = new Queue();
        preferencial = new Queue();
        chamados = new Queue();
       scanner = new Scanner(System.in);
    }

    public Queue getChamados() {
        return chamados;
    }

    public Person chamarSenha() {
            Person result = null;
        if (pessoaFisica.isEmpty() && pessoaJuridica.isEmpty() && preferencial.isEmpty()) {
            System.out.println("Não há mais pessoas para serem atendidas");
            return  result;
        } else {
            //começa a logica dos chamados

            if ((pessoaFisica.isEmpty() && pessoaJuridica.isEmpty()) || ppc == 3) {
                Person ppAtual = (Person) preferencial.dequeue();
                result = ppAtual;
                ppc = 0;
            } else if ((pessoaJuridica.isEmpty() && preferencial.isEmpty()) || (pfc == 0 && !pessoaFisica.isEmpty())) {

                Person pfAtual = (Person) pessoaFisica.dequeue();
                result = pfAtual;
                pfc = 1;
                pjc = 0;

                ppc++;
            } else if((pessoaFisica.isEmpty() && preferencial.isEmpty()) || pjc == 0 ) {

                Person pjAtual = (Person) pessoaJuridica.dequeue();
                result = pjAtual;
                pfc = 0;
                pjc = 1;
                ppc++;
            }
        }

        return  result;
    }

    public Person gerarSenha(String nome, int type){
        int pos;
        switch (type){
            case 1:
                if (pfLast ==0) {
                    pfLast  =  pessoaFisica.size() +1;
                }
                pos = pfLast++;
                Person pf = new Person(nome,pos,"PF");
                pessoaFisica.enqueue(pf);
                return pf;
            case 2:

                if (pjLast ==0) {
                    pjLast  =  pessoaJuridica.size() +1;
                }
                pos = pjLast++;
                Person pj = new Person(nome,pos,"PJ");
                pessoaJuridica.enqueue(pj);
                return pj;
            case 3:
                if (ppLast ==0) {
                    ppLast  =  preferencial.size() +1;
                }
                pos = ppLast++;
                Person pp = new Person(nome,pos,"PP");
                preferencial.enqueue(pp);
                return pp;
            default:
                return  null;

        }
    }

}
