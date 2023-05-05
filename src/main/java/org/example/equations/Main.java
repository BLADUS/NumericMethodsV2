package org.example.equations;

import javax.script.ScriptException;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

/**
 * @author Vladislav Osada
 * @date 05.05.2023 20:28
 */
public class Main {
    public static void main(String[] args) throws ScriptException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите функцию (например, x -> x * x): ");
        String functionString = scanner.nextLine();
        System.out.print("Введите значение аргумента: ");
        double x = scanner.nextDouble();
        DoubleUnaryOperator function = AuxiliaryFunctions.createFunction(functionString);
        double result = AuxiliaryFunctions.evaluate(function, x);
        System.out.println("Значение функции при x=" + x + ": " + result);
    }
}