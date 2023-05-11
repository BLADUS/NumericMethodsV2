package org.example.Interpolation.MethodsErrorInterpolationMethods;

import static org.example.Interpolation.MethodsInterpolation.InterpolationNewton.interpolateByNewton;

/**
 * @author Vladislav Osada
 * @date 12.05.2023 0:55
 */
public class ErrorByNewtonMethod {

    public static double estimateErrorByNewton(double[] arrayX, double[] arrayY, double x0) {
        double h = arrayX[1] - arrayX[0]; // шаг интерполяции
        double interpolatedValue = interpolateByNewton(arrayX, arrayY, x0);
        double interpolatedValueHalfStep = interpolateByNewton(arrayX, arrayY, x0 + h / 2);
        return Math.abs(interpolatedValue - interpolatedValueHalfStep);
    }
}
