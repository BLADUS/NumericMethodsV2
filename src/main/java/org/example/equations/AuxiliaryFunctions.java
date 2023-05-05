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
        return function.applyAsDouble(x);
    }

    public static DoubleUnaryOperator createFunction(String function) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        engine.eval("function f(x) { return " + function + "; }");
        Invocable invocable = (Invocable) engine;
        return x -> {
            try {
                Object result = invocable.invokeFunction("f", x);
                if (result instanceof Number) {
                    return ((Number) result).doubleValue();
                } else {
                    throw new IllegalArgumentException("Function result is not a number");
                }
            } catch (ScriptException | NoSuchMethodException ex) {
                throw new IllegalArgumentException("Invalid function: " + function, ex);
            }
        };
    }
}
