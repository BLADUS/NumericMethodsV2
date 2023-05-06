package org.example.equations;

import javax.script.ScriptException;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

import static org.example.equations.AuxiliaryFunctions.inputDouble;

/**
 * @author Vladislav Osada
 * @date 05.05.2023 20:28
 */
public class Main {
    static String functionString = AuxiliaryFunctions.writeFunction();
    static double x = inputDouble("Введите значение аргумента: ");

    public static void main(String[] args) throws ScriptException {
       double result = DividingSegmentInHalf.bisection(functionString);
        System.out.println(result);
    }
}