package view;

import controller.Controller;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import model.Level;

public class View {
    private static Controller controller;

    public static Controller getController() {
        return controller;
    }

    public static void setController(Controller controller) {
        View.controller = controller;
    }

    public void drawLevel(Level level) {
        drawMatrix(level.getMatrix(), controller.getCnvLevel());
        drawMatrix(level.getTarget(), controller.getCnvTarget());
    }

    private void drawMatrix(int[][] matrix, Canvas canvas) {
        int size = matrix.length;
        int cellSize = (int) Math.round(canvas.getWidth() / size);
        int x = 0;
        int y = 0;
        GraphicsContext gc = canvas.getGraphicsContext2D();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gc.setFill(getColorByValue(matrix[i][j]));
                gc.fillRect(x, y, cellSize, cellSize);
                x += cellSize;
            }
            y += cellSize;
            x = 0;
        }
        drawGrid(cellSize, canvas);
    }

    private void drawGrid(int cellSize, Canvas canvas) {
        canvas.getGraphicsContext2D().setStroke(Color.BLACK);
        for (int x = cellSize; x < canvas.getWidth(); x += cellSize) {
            canvas.getGraphicsContext2D().strokeLine(x, 0, x, canvas.getHeight());
        }
        for (int y = cellSize; y < canvas.getHeight(); y += cellSize) {
            canvas.getGraphicsContext2D().strokeLine(0, y, canvas.getWidth(), y);
        }
    }

    private Paint getColorByValue(int value) {
        switch (value) {
            case 0:
                return Color.WHITE;
            case 1:
                return Color.RED;
            case 2:
                return Color.ORANGE;
            case 3:
                return Color.YELLOW;
            case 4:
                return Color.GREEN;
            case 5:
                return Color.AQUA;
            case 6:
                return Color.BLUE;
            case 7:
                return Color.PURPLE;
            default:
                return Color.BLACK;
        }
    }

    public void declareVictory() {
        GraphicsContext gc = controller.getCnvLevel().getGraphicsContext2D();
        gc.setFill(Color.DEEPPINK);
        gc.setFont(Font.font("Verdana", 70));
        gc.fillText("Well done!", 20, 220);
    }

    public void initialize() {
        controller.initializeCanvasEventHandler();
    }
}
