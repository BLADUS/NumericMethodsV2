package org.example.Integrals.MethodsErrorIntegralsMethods;

import javax.script.ScriptException;

import static org.example.Integrals.MethodsCalculatingIntegrals.SimpsonMethod.integrateBySimpsonRule;


/**
 * @author Vladislav Osada
 * @date 12.05.2023 0:11
 */
public class ErrorByRungeRuleSimpson {
    public static double estimateErrorByRichardsonSimpson(String functionString, double[] limits, int n) throws ScriptException {
        double integral = integrateBySimpsonRule(functionString, limits, n);
        double integral2 = integrateBySimpsonRule(functionString, limits, 2 * n);

        double error = Math.abs((1 / 15.0) * (integral - integral2));

        return error;
    }
}
