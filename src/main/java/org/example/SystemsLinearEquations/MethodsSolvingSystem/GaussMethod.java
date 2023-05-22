package org.example.SystemsLinearEquations.MethodsSolvingSystem;

import org.example.SystemsLinearEquations.LinearSystem;

/**
 * @author Vladislav Osada
 * @date 10.05.2023 3:08
 */
public class GaussMethod {
    public static double[] gauss(LinearSystem system) {
        int size = system.getSize();
        double[][] coefficients = system.getCoefficients();
        double[] rightHandSide = system.getRightHandSide();

        // Прямой ход
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                double ratio = coefficients[j][i] / coefficients[i][i];
                for (int k = i; k < size; k++) {
                    coefficients[j][k] -= ratio * coefficients[i][k];
                }
                rightHandSide[j] -= ratio * rightHandSide[i];
            }
        }

        // Обратный ход
        double[] solution = new double[size];
        for (int i = size - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < size; j++) {
                sum += coefficients[i][j] * solution[j];
            }
            solution[i] = (rightHandSide[i] - sum) / coefficients[i][i];
        }

        return solution;
    }

}
