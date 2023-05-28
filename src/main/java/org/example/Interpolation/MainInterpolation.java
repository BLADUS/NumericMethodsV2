package org.example.Interpolation;

import javax.script.ScriptException;
import java.util.Arrays;
import java.util.Scanner;

import static org.example.GlobalClasses.AuxiliaryFunctions.inputDouble;
import static org.example.Interpolation.ErrorInterpolationMethod.computeErrors;
import static org.example.Interpolation.InterpolationMethod.interpolateAndPrint;
import static org.example.Interpolation.initializingXandY.InitArrayX.fillArrayX;
import static org.example.Interpolation.initializingXandY.InitArrayX.fillArrayXFromFile;
import static org.example.Interpolation.initializingXandY.InitArrayY.fillArrayY;
import static org.example.Interpolation.initializingXandY.InitArrayY.fillArrayYFromFile;


/**
 * @author Vladislav Osada
 * @date 12.05.2023 0:02
 */
public class MainInterpolation {
    static double[] arrayX = fillArrayXFromFile("src\\main\\java\\org\\example\\Interpolation\\initializingXandY\\x");
    static double[] arrayY = fillArrayYFromFile("src\\main\\java\\org\\example\\Interpolation\\initializingXandY\\y");

    static double x0;

    public static void mainMenu() throws ScriptException {
        int point = pointList();

        double EPS;
        switch (point) {
            case 0: {
                return;
            }
            case 1: {
                System.out.println("X :" + Arrays.toString(arrayX));
                System.out.println("Y :" + Arrays.toString(arrayY));
            }
            case 2: {
                fillArrayX(arrayX);
                fillArrayY(arrayY);
            }
            case 3: {
                x0 = inputDouble("Введите точку x0");
                interpolateAndPrint(x0,arrayX,arrayY);
                computeErrors(x0,arrayX,arrayY);
                break;
            }
        }
        mainMenu();
    }

    public static int pointList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите пункт меню: ");
        System.out.println("0.Выйти");
        System.out.println("1.Вывести табличные значения x и y");
        System.out.println("2.Вввести новые табличные значения x и y");
        System.out.println("3.С помощью интерполяционных многочленов степени от 1 до 4 найти значения функции, в т.x0");

        return scanner.nextInt();
    }

    public static void main(String[] args) throws ScriptException {
        mainMenu();
    }
}

