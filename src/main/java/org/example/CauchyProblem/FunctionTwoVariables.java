package org.example.CauchyProblem;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

/**
 * @author Vladislav Osada
 * @date 18.05.2023 22:03
 */
public class FunctionTwoVariables {
    // Вычисление значения функции при заданных аргументах x и y
    public static double evaluateFunctionTwoVariables(String functionString, double x, double y) throws ScriptException {
        DoubleBinaryOperator function = createFunction(functionString);
        try {
            return function.applyAsDouble(x, y);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    // Правильная обработка функции с двумя переменными x и y
    public static DoubleBinaryOperator createFunction(String function) throws ScriptException {
        function = function.replaceAll("(\\d+(,\\d+)?)\\^(\\d+)", "Math.pow($1, $3)");
        function = function.replaceAll("(\\d+(,\\d+)?)x", "$1*x");
        function = function.replaceAll("x\\^(\\d+)", "Math.pow(x, $1)");
        function = function.replaceAll("(\\d+(,\\d+)?)y", "$1*y");
        function = function.replaceAll("y\\^(\\d+)", "Math.pow(y, $1)");
        function = function.replaceAll("e", "2.7");
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        engine.eval("function f(x, y) { return " + function + "; }");
        Invocable invocable = (Invocable) engine;
        String finalFunction = function;
        return (x, y) -> {
            try {
                Object result = invocable.invokeFunction("f", x, y);
                if (result instanceof Number) {
                    return ((Number) result).doubleValue();
                } else {
                    throw new IllegalArgumentException("Function result is not a number");
                }
            } catch (ScriptException | NoSuchMethodException ex) {
                throw new IllegalArgumentException("Invalid function: " + finalFunction, ex);
            }
        };
    }

    public static String writeFunctionTwoVariables() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите функцию двух переменных (например,y-x^2): ");
        return scanner.nextLine();
    }

    public static double writeY(double x0) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение y(" + x0 + "): ");
        return scanner.nextDouble();
    }
}
