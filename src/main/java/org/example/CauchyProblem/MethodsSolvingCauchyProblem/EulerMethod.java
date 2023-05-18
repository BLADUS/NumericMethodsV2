package org.example.CauchyProblem.MethodsSolvingCauchyProblem;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

import static org.example.CauchyProblem.FunctionTwoVariables.evaluateFunctionTwoVariables;

public class EulerMethod {

    // Метод Эйлера
    public static List<Double> euler(String functionString, double[] initialValues, double h) throws ScriptException {
        List<Double> yValues = new ArrayList<>();
        yValues.add(initialValues[1]);

        double x = initialValues[0];
        double y = initialValues[1];

        int n = (int) Math.round((initialValues[2] - initialValues[0]) / h);

        for (int i = 0; i < n; i++) {
            double f = evaluateFunctionTwoVariables(functionString, x, y);
            y = y + h * f;
            x = x + h;

            System.out.println("Step " + (i + 1) + ": x = " + x + ", y = " + y);

            yValues.add(y);
        }

        return yValues;
    }

}
