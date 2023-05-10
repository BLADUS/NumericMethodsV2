package org.example.systemsLinearEquations;

/**
 * @author Vladislav Osada
 * @date 10.05.2023 3:11
 */
public class LinearSystem {
    private double[][] coefficients; // Матрица коэффициентов
    private double[] rightHandSide; // Правая часть уравнений

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
