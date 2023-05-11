package org.example.systemsLinearEquations.MethodsSolvingSystem;

import org.example.systemsLinearEquations.LinearSystem;

/**
 * @author Vladislav Osada
 * @date 11.05.2023 18:08
 */
public class SeidelMethod {

    public static double[] seidel(LinearSystem system, double epsilon) {
        int size = system.getSize();
        double[][] coefficients = system.getCoefficients();
        double[] rightHandSide = system.getRightHandSide();

        double[] solution = new double[size];
        double[] prevSolution = new double[size];
        int maxIterations = estimateMaxIterations(system, epsilon);
        int iteration = 0;

        while (iteration < maxIterations) {
            for (int i = 0; i < size; i++) {
                prevSolution[i] = solution[i];
            }

            for (int i = 0; i < size; i++) {
                double sum = 0.0;
                for (int j = 0; j < size; j++) {
                    if (j != i) {
                        sum += coefficients[i][j] * solution[j];
                    }
                }
                solution[i] = (rightHandSide[i] - sum) / coefficients[i][i];
            }

            double maxDiff = 0.0;
            for (int i = 0; i < size; i++) {
                double diff = Math.abs(solution[i] - prevSolution[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }

            if (maxDiff < epsilon) {
                break;
            }

            iteration++;
        }

        return solution;
    }

    public static int estimateMaxIterations(LinearSystem system, double epsilon) {
        int size = system.getSize();
        double[][] coefficients = system.getCoefficients();

        // Оценка числа итераций для достижения сходимости
        int maxIterations = 10 * size; // Начальное значение maxIterations

        // Рассчитываем норму матрицы коэффициентов
        double norm = calculateNorm(coefficients, size);

        // Уточняем maxIterations в зависимости от нормы
        maxIterations *= (int) Math.ceil(Math.log(1 / epsilon) / Math.log(norm));

        return maxIterations;
    }

    public static double calculateNorm(double[][] matrix, int size) {
        double norm = 0.0;

        // Вычисление нормы матрицы
        for (int i = 0; i < size; i++) {
            double rowSum = 0.0;
            for (int j = 0; j < size; j++) {
                rowSum += Math.abs(matrix[i][j]);
            }
            if (rowSum > norm) {
                norm = rowSum;
            }
        }

        return norm;
    }
}
