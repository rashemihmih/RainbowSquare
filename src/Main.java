import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Model;
import view.View;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/form.fxml"));
        primaryStage.setTitle("Rainbow Square");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        Model model = new Model();
        View view = new View();
        View.getController().setModel(model);
        model.setView(view);
        view.initialize();
        model.restart();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
