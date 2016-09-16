package model;

import java.util.Arrays;

public class Level {
    private int size;
    private int[][] matrix;
    private int[][] target;
    private static final int MAX_VALUE = 7;

    public Level(int size) {
        if (size < 1) throw new IndexOutOfBoundsException("size < 1");
        this.size = size;
        matrix = new int[size][size];
        target = new int[size][size];
    }

    public int getSize() {
        return size;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int[][] getTarget() {
        return target;
    }

    public static int getMaxValue() {
        return MAX_VALUE;
    }

    public boolean isComplete() {
        return Arrays.deepEquals(matrix, target);
    }

    public void activate(int row, int col) {
        if (row < 0 || col < 0 || row >= size || col >= size) {
            throw new IndexOutOfBoundsException("out of bounds");
        }
        decrease(row, col, 2);
        decrease(row - 1, col - 1, 1);
        decrease(row - 1, col, 1);
        decrease(row - 1, col + 1, 1);
        decrease(row, col - 1, 1);
        decrease(row, col + 1, 1);
        decrease(row + 1, col - 1, 1);
        decrease(row + 1, col, 1);
        decrease(row + 1, col + 1, 1);
    }

    private void decrease(int row, int col, int decrement) {
        if (row >= 0 && col >= 0 && row < size && col < size) {
            matrix[row][col] -= decrement;
            if (matrix[row][col] < 0) {
                matrix[row][col] = 0;
            }
        }
    }

    public void scramble(int moves) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = MAX_VALUE;
            }
        }
        for (int i = 0; i < moves; i++) {
            activate((int) (Math.random() * size), (int) (Math.random() * size));
        }
        for (int i = 0; i < size; i++) {
            target[i] = Arrays.copyOf(matrix[i], size);
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = MAX_VALUE;
            }
        }
    }
}
