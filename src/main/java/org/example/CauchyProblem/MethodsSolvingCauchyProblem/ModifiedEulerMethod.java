package org.example.CauchyProblem.MethodsSolvingCauchyProblem;

import javax.script.ScriptException;
import java.util.*;

import static org.example.CauchyProblem.FunctionTwoVariables.evaluateFunctionTwoVariables;
import static org.example.CauchyProblem.FunctionTwoVariables.writeY;

/**
 * @author Vladislav Osada
 * @date 18.05.2023 23:41
 */
public class ModifiedEulerMethod {
    // Модифицированный метод Эйлера
    public static Map<String, List<Double>> modifiedEuler(String functionString, double[] limits, double h, double y0) throws ScriptException {
        List<Double> x1 = new ArrayList<>();
        List<Double> y1 = new ArrayList<>();

        double x0 = limits[0];
        double xLast = limits[1];

        x1.add(x0);
        y1.add(y0);

        int n = (int) Math.round((xLast - x0) / h);

        for (int i = 0; i < n; i++) {
            double f1 = evaluateFunctionTwoVariables(functionString, x0, y0);
            double xHalf = x0 + h / 2.0;
            double yHalf = y0 + h / 2.0 * f1;
            double f2 = evaluateFunctionTwoVariables(functionString, xHalf, yHalf);

            double yNext = y0 + h * f2;
            x0 = x0 + h;
            y0 = yNext;

            x1.add(x0);
            y1.add(y0);
        }

        Map<String, List<Double>> result = new HashMap<>();
        result.put("x1", x1);
        result.put("y1", y1);

        return result;
    }
}
