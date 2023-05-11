package org.example.Interpolation.MethodsErrorInterpolationMethods;

import static org.example.Interpolation.MethodsInterpolation.InterpolationLagrange.interpolateByLagrange;

/**
 * @author Vladislav Osada
 * @date 12.05.2023 0:54
 */
public class ErrorByLagrangeMethod {
    public static double estimateErrorByLagrange(double[] arrayX, double[] arrayY, double x0) {
        double h = arrayX[1] - arrayX[0]; // шаг интерполяции
        double interpolatedValue = interpolateByLagrange(arrayX, arrayY, x0);
        double interpolatedValueHalfStep = interpolateByLagrange(arrayX, arrayY, x0 + h / 2);
        return Math.abs(interpolatedValue - interpolatedValueHalfStep);
    }
}
