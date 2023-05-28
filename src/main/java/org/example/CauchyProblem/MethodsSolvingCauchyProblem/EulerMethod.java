package org.example.CauchyProblem.MethodsSolvingCauchyProblem;

import javax.script.ScriptException;
import java.util.*;
import java.util.function.DoubleBinaryOperator;

import static org.example.CauchyProblem.FunctionTwoVariables.*;

/**
 * @author Vladislav Osada
 * @date 18.05.2023 22:20
 */
public class EulerMethod {

    // Метод Эйлера
    public static Map<String, List<Double>> euler(String functionString, double[] limits, double h, double y0) throws ScriptException {
        List<Double> x1 = new ArrayList<>();
        List<Double> y1 = new ArrayList<>();

        double x0 = limits[0];
        double xLast = limits[1];

        x1.add(x0);
        y1.add(y0);

        DoubleBinaryOperator function = createFunction(functionString);

        int n = (int) Math.round((xLast - x0) / h);

        for (int i = 0; i < n; i++) {
            double f = evaluateFunctionTwoVariables(functionString, x0, y0);
            y0 = y0 + h * f;
            x0 = x0 + h;

            x1.add(x0);
            y1.add(y0);
        }

        Map<String, List<Double>> result = new HashMap<>();
        result.put("x1", x1);
        result.put("y1", y1);

        return result;
    }

}
