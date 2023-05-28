package org.example.Equations;

import org.example.Equations.MethodsSolvingEquations.NewtonMethod;
import org.example.Equations.MethodsSolvingEquations.SolvingEquationsMethod;
import org.example.Equations.MethodsSolvingEquations.SimpleIterationMethod;

import javax.script.ScriptException;
import java.util.Scanner;

import static org.example.GlobalClasses.AuxiliaryFunctions.*;
import static org.example.GlobalClasses.AuxiliaryFunctions.writeEPS;
import static org.example.GlobalClasses.Function.evaluate;
import static org.example.GlobalClasses.Function.writeFunction;

/**
 * @author Vladislav Osada
 * @date 05.05.2023 20:28
 */
public class MainEquations {
    static String functionString = writeFunction();
    static double x;

    private static final double[] limits = setLimits();

    public static void mainMenu() throws ScriptException {
        int point = pointList();

        double EPS;
        switch (point) {
            case 0: {
                return;
            }
            case 1: {
                functionString = writeFunction();
                break;
            }
            case 2: {
                x = inputDouble("Введите значение аргумента");
                System.out.println(evaluate(functionString, x));
                break;
            }
            case 3: {
                System.out.println(Derivative.takeDerivative(functionString));
                break;
            }
            case 4: {
                EPS = writeEPS();
                System.out.println(SolvingEquationsMethod.bisection(functionString, EPS, limits));
                break;
            }
            case 5: {
                EPS = writeEPS();
                System.out.println(SimpleIterationMethod.iteration(functionString, EPS, limits));
                break;
            }
            case 6: {
                EPS = writeEPS();
                System.out.println(NewtonMethod.secant(functionString, EPS, limits));
                break;
            }
            default: {
                mainMenu();
                break;
            }

        }
        mainMenu();
    }

    public static int pointList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите пункт меню: ");
        System.out.println("0.Выйти");
        System.out.println("1.Ввести новую фунцию");
        System.out.println("2.Посчитать значение фун-ии при заданом аргументе");
        System.out.println("3.Найти производную");
        System.out.println("4.Решение уравнения методом бисекции");
        System.out.println("5.Решение уравнения методом простых итераций");
        System.out.println("6.Решение уравнения методом секущих");
        return scanner.nextInt();
    }

    public static void main(String[] args) throws ScriptException {
        mainMenu();
    }
}