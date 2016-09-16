package controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.Model;
import view.View;

public class Controller {
    private Model model;
    @FXML
    private Button btnRestart;
    @FXML
    private Canvas cnvLevel;
    @FXML
    private Canvas cnvTarget;

    public Controller() {
        View.setController(this);
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Canvas getCnvLevel() {
        return cnvLevel;
    }

    public Canvas getCnvTarget() {
        return cnvTarget;
    }

    @FXML
    private void onBtnRestartClicked() {
        model.restart();
    }

    public void initializeCanvasEventHandler() {
        cnvLevel.addEventHandler(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> model.handleCanvasClick(mouseEvent.getX(), mouseEvent.getY(), cnvLevel.getWidth()));
    }
}
