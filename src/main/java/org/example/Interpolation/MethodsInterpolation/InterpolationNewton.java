package org.example.Interpolation.MethodsInterpolation;

/**
 * @author Vladislav Osada
 * @date 12.05.2023 0:40
 */
public class InterpolationNewton {
    public static double interpolateByNewton(double[] x, double[] y, double x0) {
        int n = x.length;

        double result = 0;

        double[][] dividedDifferences = new double[n][n];
        for (int i = 0; i < n; i++) {
            dividedDifferences[i][0] = y[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dividedDifferences[j][i] = (dividedDifferences[j + 1][i - 1] - dividedDifferences[j][i - 1]) / (x[j + i] - x[j]);
            }
        }

        double term = 1;
        for (int i = 0; i < n; i++) {
            result += term * dividedDifferences[0][i];
            term *= (x0 - x[i]);
        }

        return result;
    }
}
