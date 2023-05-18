package org.example.Equations.MethodsSolvingEquations;

import org.example.Equations.Derivative;

import javax.script.ScriptException;

import static org.example.GlobalClasses.Function.evaluate;

/**
 * @author Vladislav Osada
 * @date 09.05.2023 23:09
 */
public class NewtonMethod {
    public static double secant(String functionString,double EPS,double[] limits) throws ScriptException {
        String firstDerivative = Derivative.takeDerivative(functionString);
        String secondDerivative = Derivative.takeDerivative(firstDerivative);

        double leftBoundary = limits[0];
        double rightBoundary = limits[1];

        double valueLeftBoundFunction = evaluate(functionString, leftBoundary);
        double valueRightBoundFunction = evaluate(functionString, rightBoundary);

        double valueLeftBoundFirstDerivative = evaluate(firstDerivative, leftBoundary);
        double valueRightBoundFirstDerivative = evaluate(firstDerivative, rightBoundary);

        double valueLeftBoundSecondDerivative = evaluate(secondDerivative, leftBoundary);
        double valueRightBoundSecondDerivative = evaluate(secondDerivative, rightBoundary);

        double x0;

        if (valueLeftBoundFunction * valueLeftBoundSecondDerivative > 0){
            x0 = leftBoundary;
        }else if (valueRightBoundFunction * valueRightBoundSecondDerivative > 0){
            x0 = rightBoundary;
        }else {
            System.out.println("Неверно выбран начальный интревал!");
            return Double.NaN;
        }

        double x = x0 - (evaluate(functionString,x0) / evaluate(firstDerivative,x0));
        while(Math.abs(x - x0) >= EPS){
            x0 = x - (evaluate(functionString,x)/evaluate(firstDerivative,x));
            x = x0 - (evaluate(functionString,x0)/evaluate(firstDerivative,x0));
        }
        return x;
    }
}
