package org.example.systemsLinearEquations;

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
}
