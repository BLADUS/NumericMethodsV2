package org.example.systemsLinearEquations;

import java.util.Scanner;

/**
 * @author Vladislav Osada
 * @date 10.05.2023 3:11
 */
public class LinearSystem {
    private final double[][] coefficients; // Матрица коэффициентов
    private final double[] rightHandSide; // Правая часть уравнений

    public LinearSystem(double[][] coefficients, double[] rightHandSide) {
        this.coefficients = coefficients;
        this.rightHandSide = rightHandSide;
    }

    public int getSize() {
        return coefficients.length;
    }
    public double[][] getCoefficients() {
        return coefficients;
    }

    public double[] getRightHandSide() {
        return rightHandSide;
    }

    public static LinearSystem readSystemFromManualInput() {
        Scanner scanner = new Scanner(System.in);

        // Ввод размера системы
        System.out.print("Введите размер системы (количество уравнений): ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Чтение символа новой строки после ввода числа

        // Инициализация массивов коэффициентов и правой части
        double[][] coefficients = new double[size][size];
        double[] rightHandSide = new double[size];

        // Ввод коэффициентов матрицы A
        System.out.println("Введите коэффициенты матрицы A:");
        for (int i = 0; i < size; i++) {
            System.out.printf("Уравнение %d:%n", i + 1);
            for (int j = 0; j < size; j++) {
                System.out.printf("Введите коэффициент A[%d][%d]: ", i, j);
                coefficients[i][j] = scanner.nextDouble();
            }
            scanner.nextLine(); // Чтение символа новой строки после ввода числа

            System.out.printf("Введите значение правой части b[%d]: ", i);
            rightHandSide[i] = scanner.nextDouble();
            scanner.nextLine(); // Чтение символа новой строки после ввода числа
        }

        // Создание объекта LinearSystem
        return new LinearSystem(coefficients, rightHandSide);
    }

    public static void printSystemEquations(LinearSystem system) {
        int size = system.getSize();
        double[][] coefficients = system.getCoefficients();
        double[] rightHandSide = system.getRightHandSide();

        System.out.println("Уравнения системы:");
        for (int i = 0; i < size; i++) {
            System.out.printf("Уравнение %d: ", i + 1);
            for (int j = 0; j < size; j++) {
                System.out.printf("%.2f * x%d", coefficients[i][j], j + 1);
                if (j < size - 1) {
                    System.out.print(" + ");
                }
            }
            System.out.printf(" = %.2f%n", rightHandSide[i]);
        }
    }
}
