package Matriks;

import java.util.Scanner;

public class Matriks_PECAHAN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Matriks pertama
        System.out.println("Masukkan elemen matriks pertama:");
        double[][] matrix1 = readMatrix(input);

        // Matriks kedua
        System.out.println("Masukkan elemen matriks kedua:");
        double[][] matrix2 = readMatrix(input);

        // Penjumlahan Matriks
        double[][] additionResult = addMatrices(matrix1, matrix2);
        System.out.println("Hasil Penjumlahan Matriks:");
        printMatrix(additionResult);

        // Pengurangan Matriks
        double[][] subtractionResult = subtractMatrices(matrix1, matrix2);
        System.out.println("Hasil Pengurangan Matriks:");
        printMatrix(subtractionResult);

        // DOT Matriks (Perkalian Skalar)
        double dotProduct = dotProduct(matrix1, matrix2);
        System.out.println("Hasil DOT Matriks (Perkalian Skalar): " + dotProduct);

        // Transpose Matriks
        double[][] transposeResult = transposeMatrix(matrix1);
        System.out.println("Hasil Transpose Matriks:");
        printMatrix(transposeResult);

        // Invers Matriks
        double[][] inverseResult = inverseMatrix(matrix1);
        if (inverseResult != null) {
            System.out.println("Hasil Invers Matriks:");
            printMatrix(inverseResult);
        }
    }

    public static double[][] readMatrix(Scanner input) {
        double[][] matrix = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        return matrix;
    }

    public static double[][] addMatrices(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static double[][] subtractMatrices(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static double dotProduct(double[][] matrix1, double[][] matrix2) {
        double result = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result += matrix1[i][j] * matrix2[i][j];
            }
        }
        return result;
    }

    public static double[][] transposeMatrix(double[][] matrix) {
        double[][] result = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    public static double[][] inverseMatrix(double[][] matrix) {
        double determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        if (determinant == 0) {
            System.out.println("Matriks tidak memiliki invers karena determinannya nol.");
            return null;
        } else {
            double inverseDet = 1.0 / determinant;
            double[][] result = new double[2][2];
            result[0][0] = matrix[1][1] * inverseDet;
            result[0][1] = -matrix[0][1] * inverseDet;
            result[1][0] = -matrix[1][0] * inverseDet;
            result[1][1] = matrix[0][0] * inverseDet;
            return result;
        }
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
