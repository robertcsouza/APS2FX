package controller;

import Models.Person;
import enums.Route;
import interfaces.Call;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Engine;
import sample.Main;
import java.util.Observable;

public class MainController extends Observable implements Call {


    @FXML
    TextField txNome;

    @FXML public ChoiceBox choiceBox;

    @FXML Label passPos;
    @FXML Label passName;

    public static ChoiceBox types;
    public static Label pos,name;
    TicketScreenController observer = null;
    Engine engine = null;

    public MainController() {

        observer = new TicketScreenController();
        engine = new Engine();
        this.addObserver(observer);

    }


    @FXML public void initialize(){

        types = choiceBox;
        pos = passPos;
        name = passName;
    }

    public void open (){
        Main.routes(Route.CALL);
    }

    public void callPass(){
        Person person = engine.chamarSenha();
        call(person);
    }

    public void generateTicket(){
        Person p = null;
        String nome = txNome.getText().toString();
        String tp = types.getValue().toString();

        System.out.println(tp);

        switch (tp){
            case "Física":
               p = engine.gerarSenha(nome,1);
                showInScreen(p);
                break;
            case "Juridica":
                 p = engine.gerarSenha(nome,2);
                showInScreen(p);
                break;

            case "Preferencial":
                p = engine.gerarSenha(nome,3);
                showInScreen(p);
                break;
        }

    }

    public void showInScreen(Person person){
        pos.setText(person.getType() +""+person.getPos());
        name.setText(person.getName());
    }


    @Override
    public void call(Person person) {

        this.change(person);
    }

    public void change(Object ticket){
        setChanged();
        notifyObservers(ticket);
    }
}
