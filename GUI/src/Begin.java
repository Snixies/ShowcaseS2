import javafx.application.Application;
import javafx.stage.Stage;

public class Begin extends Application {
    Facade facade;
/*
    public Begin(Facade facade){
        this.facade = facade;
    }

    Stage window;
    Scene scene;
    Button loginButton;
    VBox menuRight;
    Boolean logedIn = false;
    Scene scene1;
    public static NormalUser person;

    String UAccount = "uAccount";
*/

    @Override
    public void start(Stage primaryStage) throws Exception {
/*
            window = primaryStage;
            window.setTitle("");

            BorderPane beginscreen = new BorderPane();
            BorderPane borderPane = new BorderPane();

            GridPane loginGrid = new GridPane();
            loginGrid.setPadding(new Insets(10, 10, 10, 10));
            loginGrid.setVgap(8);
            loginGrid.setHgap(10);

            Label nameLabel = new Label("uAccount:");
            loginGrid.setConstraints(nameLabel, 0, 0);

            TextField nameInput = new TextField();
            nameInput.setPromptText("Vnumber");
            loginGrid.setConstraints(nameInput, 1, 0);

            Label passLabel = new Label("Password:");
            loginGrid.setConstraints(passLabel, 0, 1);

// set text op achtergrond
            PasswordField passInput = new PasswordField();
            passInput.setPromptText("Password");
            loginGrid.setConstraints(passInput, 1, 1);

            Button loginButton = new Button("Log in");
            loginButton.setOnAction(e -> {
                person(nameInput.getText(), passInput.getText());

                System.out.println(person.getVNumber());
                System.out.println(person.getPassword());
                logedIn = facade.Login(person);
                System.out.println(logedIn);

                if (logedIn) {
                    window.setScene(scene1);
                }
            });

            loginGrid.setConstraints(loginButton, 1, 2);

            loginGrid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
            loginGrid.setPadding(new Insets(20, 20, 20, 20));

            Button useCase1 = new Button("Use case 1");
            Button useCase2 = new Button("Use case 2");
            Button useCase3 = new Button("Use case 3");

            menuRight = new VBox(20);
            menuRight.getChildren().addAll(useCase1, useCase2, useCase3);
            menuRight.setPadding(new Insets(20, 20, 20, 20));

            beginscreen.setCenter(loginGrid);

            Label name = new Label("U-Account: ");
            Label uAccount = new Label(UAccount);

            GridPane normalGrid = new GridPane();
            normalGrid.setPadding(new Insets(10, 10, 10, 10));
            normalGrid.setVgap(8);
            normalGrid.setHgap(10);

            normalGrid.setConstraints(name, 0, 0);
            normalGrid.setConstraints(uAccount, 0, 1);
            normalGrid.getChildren().addAll(name, uAccount);

            borderPane.setCenter(normalGrid);
            borderPane.setRight(menuRight);

            Scene scene = new Scene(beginscreen, 400, 400);
            Scene scene1 = new Scene(borderPane, 400, 400);
            window.setScene(scene);
            window.show();

 */
    }

}