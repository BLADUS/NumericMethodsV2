package org.example.equations;

import javax.script.ScriptException;

import static org.example.equations.AuxiliaryFunctions.*;

/**
 * @author Vladislav Osada
 * @date 05.05.2023 20:29
 */
public class DividingSegmentInHalf {
    public static double bisection(String functionString,double EPS) throws ScriptException {
        double leftBoundary = inputDouble("Введите левую границу: ");
        double rightBoundary = inputDouble("Введите правую границу: ");

        double valueLeftBoundFunction = evaluate(functionString, leftBoundary);
        double valueRightBoundFunction = evaluate(functionString, rightBoundary);

        if (valueLeftBoundFunction * valueRightBoundFunction > 0) {
            System.out.println("На заданном интервале нет корней!");
            bisection(functionString,EPS);
        }

        double x0 = (leftBoundary + rightBoundary) / 2;
        while (Math.abs(rightBoundary - leftBoundary) >= EPS) {
            double valueX0Function = evaluate(functionString, leftBoundary);
            if (valueRightBoundFunction * valueX0Function >= EPS) {
                rightBoundary = x0;
            } else {
                leftBoundary = x0;
            }
            x0 = (leftBoundary + rightBoundary) / 2;
        }
        return x0;
    }

    public static double writeEPS() {
        return inputDouble("Введите точность: ");
    }
}
