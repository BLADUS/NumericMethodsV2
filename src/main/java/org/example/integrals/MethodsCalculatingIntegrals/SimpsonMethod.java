package org.example.integrals.MethodsCalculatingIntegrals;

import javax.script.ScriptException;
import java.util.function.DoubleUnaryOperator;

import static org.example.integrals.Function.createFunction;

/**
 * @author Vladislav Osada
 * @date 11.05.2023 21:26
 */
public class SimpsonMethod {

    public static double integrateBySimpsonRule(String functionString, double[] limits, int n) throws ScriptException, ScriptException {
        double a = limits[0];
        double b = limits[1];

        if (n % 2 != 0) {
            throw new IllegalArgumentException("Number of intervals (n) must be even for Simpson's rule.");
        }
        DoubleUnaryOperator function = createFunction(functionString);
        double h = (b - a) / n;
        double sum = function.applyAsDouble(a) + function.applyAsDouble(b);
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += (i % 2 == 0) ? 2 * function.applyAsDouble(x) : 4 * function.applyAsDouble(x);
        }
        return h / 3 * sum;
    }
}
