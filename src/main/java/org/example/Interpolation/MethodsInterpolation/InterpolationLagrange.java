package org.example.Interpolation.MethodsInterpolation;

/**
 * @author Vladislav Osada
 * @date 12.05.2023 0:03
 */
public class InterpolationLagrange {
    public static double interpolateByLagrange(double[] x, double[] y, double x0) {
        int n = x.length;

        double result = 0;

        for (int i = 0; i < n; i++) {
            double term = y[i];

            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term *= (x0 - x[j]) / (x[i] - x[j]);
                }
            }

            result += term;
        }

        return result;
    }
}
