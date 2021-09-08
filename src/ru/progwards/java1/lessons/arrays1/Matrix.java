package ru.progwards.java1.lessons.arrays1;

public class Matrix {

    private int[][] matrix;

    public Matrix(int[][] matrix){
        this.matrix = matrix;
    }

    public int maxInRow(int num){
        int max = Integer.MIN_VALUE;
        int[] row = this.matrix[num];

        for (int i = 0; i < row.length; i++){
            if (row[i] > max) max = row[i];
        }

        return max;
    }

    public int maxInCol(int num){
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < this.matrix.length; i++){
            if (num >= this.matrix[i].length) continue;
            if (this.matrix[i][num] > max) max = this.matrix[i][num];
        }

        return max;
    }

    public int max(){
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < this.matrix.length; i++){
            int mir = maxInRow(i);
            if (mir > max) max = mir;
        }

        return max;

    }

    public boolean isMatrix(){
        int rl = this.matrix[0].length;

        for (int i = 0; i < this.matrix.length; i++){
            if (this.matrix[i].length != rl) return false;
        }

        return true;
    }

    public int[][] transposition(){
        if (!isMatrix()) return null;

        int rl = this.matrix[0].length;
        int cl = this.matrix.length;

        int result[][] = new int[rl][cl];

        for (int r = 0; r < rl; r++) {
            for (int c = 0; c < cl; c++) {
                result[r][c] = this.matrix[c][r];
            }
        }
        return result;
    }
}
