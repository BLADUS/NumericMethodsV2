package org.example.SystemsLinearEquations.MethodsSolvingSystem;

import org.example.SystemsLinearEquations.LinearSystem;

/**
 * @author Vladislav Osada
 * @date 11.05.2023 18:08
 */
public class SeidelMethod {

    public static double[] seidel(LinearSystem system, double epsilon) {
        int maxIterations = 100000;
        int size = system.getSize();
        double[][] coefficients = system.getCoefficients();
        double[] rightHandSide = system.getRightHandSide();

        double[] solution = new double[size];
        double[] prevSolution = new double[size];
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

            double maxDiff = calculateNormDifference(solution, prevSolution); // Используем метод calculateNormDifference для расчета разности

            if (maxDiff < epsilon) {
                break;
            }

            iteration++;
        }

        return solution;
    }

    public static double calculateNormDifference(double[] array1, double[] array2) {
        double maxDiff = 0.0;
        for (int i = 0; i < array1.length; i++) {
            double diff = Math.abs(array1[i] - array2[i]);
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        return maxDiff;
    }
}
