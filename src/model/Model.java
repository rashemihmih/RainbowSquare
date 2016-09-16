package model;

import view.View;

public class Model {
    private View view;
    private Level level;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void restart() {
        level = new Level(4);
        level.scramble(3);
        view.drawLevel(level);
    }

    public void handleCanvasClick(double x, double y, double canvasWidth) {
        double cellSize = canvasWidth / level.getSize();
        level.activate((int) (y / cellSize), (int) (x / cellSize));
        view.drawLevel(level);
        if (level.isComplete()) {
            view.declareVictory();
        }
    }
}
