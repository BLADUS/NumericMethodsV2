package org.example.Integrals.MethodsErrorIntegralsMethods;

import javax.script.ScriptException;

import static org.example.Integrals.Function.evaluate;

/**
 * @author Vladislav Osada
 * @date 12.05.2023 0:11
 */
public class ErrorByRungeRuleSimpson {
    public static double estimateErrorByRungeRuleSimpson(String functionString, double[] limits, int n) throws ScriptException {
        double a = limits[0];
        double b = limits[1];

        double h = (b - a) / n;
        double sum1 = 0;
        double sum2 = 0;

        for (int i = 1; i <= n / 2; i++) {
            double x = a + (2 * i - 1) * h;
            sum1 += evaluate(functionString, x);
        }

        for (int i = 1; i <= n / 2 - 1; i++) {
            double x = a + 2 * i * h;
            sum2 += evaluate(functionString, x);
        }

        double integral = (h / 3) * (evaluate(functionString, a) + evaluate(functionString, b) + 4 * sum1 + 2 * sum2);

        double h2 = h / 2;
        double sum1_2 = 0;
        double sum2_2 = 0;

        for (int i = 1; i <= n; i++) {
            double x = a + (i - 0.5) * h2;
            sum1_2 += evaluate(functionString, x);
        }

        for (int i = 1; i <= n - 1; i++) {
            double x = a + i * h2;
            sum2_2 += evaluate(functionString, x);
        }

        double integral2 = (h2 / 3) * (evaluate(functionString, a) + evaluate(functionString, b) + 4 * sum1_2 + 2 * sum2_2);

        double error = Math.abs((1 / 15.0) * (integral - integral2));

        return error;
    }
}
