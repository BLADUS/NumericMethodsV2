package org.example.Integrals;

import javax.script.ScriptException;
import java.util.Scanner;

import static org.example.GlobalClasses.AuxiliaryFunctions.*;
import static org.example.GlobalClasses.Function.writeFunction;
import static org.example.Integrals.MethodsCalculatingIntegrals.SimpsonMethod.integrateBySimpsonRule;
import static org.example.Integrals.MethodsCalculatingIntegrals.TrapezoidMethod.integrateByTrapezoidRule;
import static org.example.Integrals.MethodsErrorIntegralsMethods.ErrorByRungeRuleSimpson.estimateErrorByRichardsonSimpson;
import static org.example.Integrals.MethodsErrorIntegralsMethods.ErrorByRungeRuleTrapezoid.estimateErrorByRungeRuleTrapezoid;


/**
 * @author Vladislav Osada
 * @date 10.05.2023 3:05
 */
public class MainIntegrals {
    static String functionString = writeFunction();
    static final int NumberOfPartitions = 20;
    private static final double[] limits = setLimits();
    static double integralByTrapezoid;
    static double integralBySimpson;


    public static void mainMenu() throws ScriptException {
        int point = pointList();

        double EPS;
        switch (point) {
            case 0: {
                return;
            }
            case 1: {
                integralByTrapezoid = integrateByTrapezoidRule(functionString, limits, NumberOfPartitions);
                System.out.println("Интеграл по формуле трапеций: " + integralByTrapezoid);
                System.out.println("Оценка погрешности по правилу Рунге: " + estimateErrorByRungeRuleTrapezoid(functionString, limits, NumberOfPartitions));
                break;
            }
            case 2: {
                integralBySimpson = integrateBySimpsonRule(functionString, limits, NumberOfPartitions);
                System.out.println("Интеграл по формуле Симпсона: " + integralBySimpson);
                System.out.println("Оценка погрешности по правилу Рунге: " + estimateErrorByRichardsonSimpson(functionString, limits, NumberOfPartitions));
                break;
            }
        }
        mainMenu();
    }

    public static int pointList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите пункт меню: ");
        System.out.println("0.Выйти");
        System.out.println("1.Вычислить интеграл методом трапеций");
        System.out.println("2.Вычислить интеграл методом Симпосона");
        return scanner.nextInt();
    }

    public static void main(String[] args) throws ScriptException {
        mainMenu();
    }
}
