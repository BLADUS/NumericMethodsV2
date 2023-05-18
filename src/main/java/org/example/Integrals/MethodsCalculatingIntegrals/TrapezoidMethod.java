package org.example.Integrals.MethodsCalculatingIntegrals;

import javax.script.ScriptException;
import java.util.function.DoubleUnaryOperator;

import static org.example.GlobalClasses.Function.createFunction;


/**
 * @author Vladislav Osada
 * @date 11.05.2023 20:07
 */
public class TrapezoidMethod {
    public static double integrateByTrapezoidRule(String functionString, double[] limits, int n) throws ScriptException, ScriptException {
        double a = limits[0];
        double b = limits[1];

        DoubleUnaryOperator function = createFunction(functionString);
        double h = (b - a) / n;
        double sum = 0.5 * (function.applyAsDouble(a) + function.applyAsDouble(b));
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += function.applyAsDouble(x);
        }
        return h * sum;
    }
}
