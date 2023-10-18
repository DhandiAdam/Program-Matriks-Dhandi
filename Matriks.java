package Matriks;

import java.util.Scanner;

public class Matriks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta input untuk matriks A
        System.out.println("Masukkan elemen-elemen matriks A (2x2):");
        double[][] matrixA = readMatrix(scanner);

        // Meminta input untuk matriks B
        System.out.println("Masukkan elemen-elemen matriks B (2x2):");
        double[][] matrixB = readMatrix(scanner);

        // Menampilkan matriks A
        System.out.println("Matriks A:");
        printMatrix(matrixA);

        // Menampilkan matriks B
        System.out.println("Matriks B:");
        printMatrix(matrixB);

        // Melakukan penjumlahan matriks
        double[][] additionResult = addMatrices(matrixA, matrixB);
        System.out.println("Hasil penjumlahan matriks A + B:");
        printMatrix(additionResult);

        // Melakukan pengurangan matriks
        double[][] subtractionResult = subtractMatrices(matrixA, matrixB);
        System.out.println("Hasil pengurangan matriks A - B:");
        printMatrix(subtractionResult);

        // Melakukan perkalian (dot product) matriks
        double dotProductResult = dotProduct(matrixA, matrixB);
        System.out.println("Hasil perkalian matriks A . B (dot product): " + dotProductResult);

        // Melakukan transpose matriks A
        double[][] transposeResultA = transposeMatrix(matrixA);
        System.out.println("Transpose matriks A:");
        printMatrix(transposeResultA);

        // Melakukan invers matriks A
        double[][] inverseResultA = invertMatrix(matrixA);
        if (inverseResultA != null) {
            System.out.println("Invers matriks A:");
            printMatrix(inverseResultA);
        } else {
            System.out.println("Matriks A tidak memiliki invers.");
        }
    }

    public static double[][] readMatrix(Scanner scanner) {
        double[][] matrix = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Elemen matriks [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    public static double[][] addMatrices(double[][] matrixA, double[][] matrixB) {
        double[][] result = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return result;
    }

    public static double[][] subtractMatrices(double[][] matrixA, double[][] matrixB) {
        double[][] result = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        return result;
    }

    public static double dotProduct(double[][] matrixA, double[][] matrixB) {
        double result = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result += matrixA[i][j] * matrixB[i][j];
            }
        }
        return result;
    }

    public static double[][] transposeMatrix(double[][] matrix) {
        double[][] result = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static double[][] invertMatrix(double[][] matrix) {
        double determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        if (determinant == 0) {
            return null;
        }

        double[][] result = new double[2][2];
        result[0][0] = matrix[1][1] / determinant;
        result[0][1] = -matrix[0][1] / determinant;
        result[1][0] = -matrix[1][0] / determinant;
        result[1][1] = matrix[0][0] / determinant;

        return result;
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}