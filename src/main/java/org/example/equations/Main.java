package org.example.equations;

import javax.script.ScriptException;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

/**
 * @author Vladislav Osada
 * @date 05.05.2023 20:28
 */
public class Main {
   static String functionString = AuxiliaryFunctions.writeFunction();
    public static void main(String[] args) throws ScriptException {
        double result = AuxiliaryFunctions.evaluate(functionString);
        System.out.println(result);
    }
}