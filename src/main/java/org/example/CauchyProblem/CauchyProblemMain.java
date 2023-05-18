package org.example.CauchyProblem;

import javax.script.ScriptException;
import java.util.Scanner;

import static org.example.CauchyProblem.FunctionTwoVariables.writeFunctionTwoVariables;
import static org.example.CauchyProblem.MethodsSolvingCauchyProblem.EulerMethod.euler;
import static org.example.CauchyProblem.MethodsSolvingCauchyProblem.ModifiedEulerMethod.modifiedEuler;
import static org.example.CauchyProblem.MethodsSolvingCauchyProblem.RungeKutta4Method.rungeKutta4;
import static org.example.GlobalClasses.AuxiliaryFunctions.inputDouble;
import static org.example.GlobalClasses.AuxiliaryFunctions.setLimits;

/**
 * @author Vladislav Osada
 * @date 18.05.2023 22:15
 */

public class CauchyProblemMain {
    private static final String functionString = writeFunctionTwoVariables();
    private static final double[] limits = setLimits();

    private static final double h = inputDouble("Введите значение шага h:");

    public static void mainMenu() throws ScriptException {
        int point = pointList();

        switch (point) {
            case 0: {
                return;
            }
            case 1: {
                euler(functionString, limits, h);
                break;
            }
            case 2: {
                modifiedEuler(functionString, limits, h);
                break;
            }
            case 3: {
                rungeKutta4(functionString, limits, h);
                break;
            }
        }
        mainMenu();
    }

    public static int pointList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите пункт меню: ");
        System.out.println("0. Выйти");
        System.out.println("1. Решить задачу Коши методом Эйлера");
        System.out.println("2. Решить задачу Коши усовершеннстованным методом Эйлера");
        System.out.println("3. Решить задачу Коши методом Рунге-Кутты 4-го порядка");

        return scanner.nextInt();
    }

    public static void main(String[] args) throws ScriptException {
        mainMenu();
    }
}
