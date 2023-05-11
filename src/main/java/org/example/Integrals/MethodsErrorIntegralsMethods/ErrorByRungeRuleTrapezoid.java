package org.example.Integrals.MethodsErrorIntegralsMethods;

import javax.script.ScriptException;

import static org.example.Integrals.MethodsCalculatingIntegrals.TrapezoidMethod.integrateByTrapezoidRule;

/**
 * @author Vladislav Osada
 * @date 12.05.2023 0:11
 */
public class ErrorByRungeRuleTrapezoid {

    public static double estimateErrorByRungeRuleTrapezoid(String functionString, double[] limits, int n) throws ScriptException {
        double a = limits[0];
        double b = limits[1];

        // Вычисляем интеграл с более грубым разбиением
        int nCoarse = n / 2;
        double integralCoarse = integrateByTrapezoidRule(functionString, limits, nCoarse);

        // Вычисляем интеграл с более точным разбиением
        double integralFine = integrateByTrapezoidRule(functionString, limits, n);

        // Оцениваем погрешность решения по правилу Рунге
        return Math.abs(integralFine - integralCoarse) / (Math.pow(2, 2) - 1);
    }
}
