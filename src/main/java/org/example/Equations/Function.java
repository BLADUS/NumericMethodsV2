package org.example.Equations;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

/**
 * @author Vladislav Osada
 * @date 09.05.2023 16:33
 */
public class Function {
    //Метод который считает значение фун-ии при переданном аргументе
    public static double evaluate(String functionString, double x) throws ScriptException {
        DoubleUnaryOperator function = createFunction(functionString);
        try {
            double result = function.applyAsDouble(x);
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    //Правильная обработка функции
    public static DoubleUnaryOperator createFunction(String function) throws ScriptException {
        function = function.replaceAll("(\\d+(,\\d+)?)\\^(\\d+)", "Math.pow($1, $3)");
        function = function.replaceAll("(\\d+(,\\d+)?)x", "$1*x");
        function = function.replaceAll("x\\^(\\d+)", "Math.pow(x, $1)");
        function = function.replaceAll("e", "2.7");
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        engine.eval("function f(x) { return " + function + "; }");
        Invocable invocable = (Invocable) engine;
        String finalFunction = function;
        return x -> {
            try {
                Object result = invocable.invokeFunction("f", x);
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

    public static String writeFunction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите функцию (например, x^3+9*x^1-11): ");
        return scanner.nextLine();
    }
}
