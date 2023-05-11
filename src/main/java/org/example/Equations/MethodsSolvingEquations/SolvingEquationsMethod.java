package org.example.Equations.MethodsSolvingEquations;

import javax.script.ScriptException;

import java.util.Scanner;

import static org.example.Equations.Function.evaluate;

/**
 * @author Vladislav Osada
 * @date 05.05.2023 20:29
 */
public class SolvingEquationsMethod {
    public static double bisection(String functionString, double EPS, double[] limits) throws ScriptException {
        Scanner scanner = new Scanner(System.in);

        double leftBoundary = limits[0];
        double rightBoundary = limits[1];

        double valueLeftBoundFunction = evaluate(functionString, leftBoundary);
        double valueRightBoundFunction = evaluate(functionString, rightBoundary);

        if (valueLeftBoundFunction * valueRightBoundFunction > 0) {
            System.out.println("На заданном интервале нет корней!");
            return Double.NaN; // Возвращаем NaN, чтобы показать, что корень не найден.
        }

        double x0 = (leftBoundary + rightBoundary) / 2;

        while (Math.abs(rightBoundary - leftBoundary) >= EPS) {
            double valueX0Function = evaluate(functionString, x0);

            if (valueRightBoundFunction * valueX0Function >= 0) {
                rightBoundary = x0;
            } else {
                leftBoundary = x0;
            }

            x0 = (leftBoundary + rightBoundary) / 2;
        }

        return x0;
    }

}
