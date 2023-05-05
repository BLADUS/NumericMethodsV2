package org.example.equations;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

/**
 * @author Vladislav Osada
 * @date 05.05.2023 20:45
 */
public class AuxiliaryFunctions {
    //Метод который считает значение фун-ии при переданном аргументе
    public static double evaluate(DoubleUnaryOperator function, double x) {
        try {
            return function.applyAsDouble(x);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public static DoubleUnaryOperator createFunction(String function) throws ScriptException {
        function = function.replaceAll("(\\d+)\\^(\\d+)", "Math.pow($1, $2)");
        function = function.replaceAll("x\\^(\\d+)", "Math.pow(x, $1)");
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
}
