package sample;

import enums.Route;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private static  Stage stage;
    private static  Scene CreatePass;
    private static  Scene CallPass;

    @Override
    public void start(Stage primaryStage) throws Exception{




        stage = primaryStage;
        Parent createPass = FXMLLoader.load(getClass().getResource("../views/Main.fxml"));
        CreatePass = new Scene(createPass,800,400);

        Parent callPass = FXMLLoader.load(getClass().getResource("../views/TicketScreen.fxml"));
        CallPass = new Scene(callPass,600,400);
        primaryStage.setTitle("Receita Federal Senhas");

        stage.setScene(CreatePass);
        stage.show();

    }

    public static void routes(Route route){

        switch (route){

            case MAIN:
                stage.setScene(CreatePass);
                break;
            case CALL:

                Stage st = new Stage();
                st.setScene(CallPass);
                st.show();


                break;
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
