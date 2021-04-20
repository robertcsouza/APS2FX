package controller;


import Models.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import sample.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class TicketScreenController implements Observer{


    Engine engine = null;

    @FXML
     public  Label lableOne;
    @FXML
     public  Label lableName;
    @FXML
     public ListView<String> lastCall;

    List<String> calls = new ArrayList<String>();

    public static Label label;
    public static Label labelN;
    public static ListView list;

    @FXML public void initialize(){
            label = lableOne;
            labelN = lableName;
            list = lastCall;


    }

    public TicketScreenController() {
        engine = new Engine();
    }

    @Override
    public void update(Observable o, Object arg) {
        Person person =(Person) arg;
        if(person != null){
            label.setText(person.getType()+" "+person.getPos());
            labelN.setText(person.getName());
            calls.add(person.getType()+" "+person.getPos());

            list.getItems().addAll(calls);
            calls.clear();

        }else{
            label.setText("Não há mais Pessoas ");
        }
    }
}
