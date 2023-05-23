package org.example.Equations.MethodsSolvingEquations;

import javax.script.ScriptException;

import static org.example.GlobalClasses.Function.evaluate;

/**
 * @author Vladislav Osada
 * @date 07.05.2023 22:31
 */
public class SimpleIterationMethod {

    public static double iteration(String functionString, double EPS, double[] limits) throws ScriptException {
        int i = 1;
        double x = evaluate(functionString, limits[0]);
        double x0 = evaluate(functionString, x);

        while (true) {
            if (Math.abs(x - x0) < EPS) {
                System.out.println("Количество шагов: " + i);
                return x0;
            }

            x = evaluate(functionString, x0);
            x0 = x;
            i++;

            if (i == 10000) {
                System.out.println("Выполнено 10000 итераций, решение не найдено!");
                return Double.NaN;
            }
        }
    }

}
