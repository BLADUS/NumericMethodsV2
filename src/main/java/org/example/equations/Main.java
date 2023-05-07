package org.example.equations;

import javax.script.ScriptException;
import java.util.Scanner;

import static org.example.equations.AuxiliaryFunctions.*;
import static org.example.equations.AuxiliaryFunctions.writeEPS;

/**
 * @author Vladislav Osada
 * @date 05.05.2023 20:28
 */
public class Main {
    static String functionString = writeFunction();
    static double x;
    private static double EPS;

    private static final double[] limits = setLimits();

    public static void mainMenu() throws ScriptException {
        int point = pointList();

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
                EPS = writeEPS();
                System.out.println(DividingSegmentInHalf.bisection(functionString, EPS, limits));
                break;
            }
            case 4: {
                EPS = writeEPS();
                System.out.println(SimpleIterationMethod.iteration(functionString,EPS,limits));
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
        System.out.println("3.Решение уравнения методом бисекции");
        System.out.println("4.Решение уравнения методом прстых итераций");
        return scanner.nextInt();
    }

    public static void main(String[] args) throws ScriptException {
        mainMenu();
    }
}