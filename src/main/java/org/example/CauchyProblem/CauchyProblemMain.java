package org.example.CauchyProblem;

import javax.script.ScriptException;
import java.util.Scanner;


public class CauchyProblemMain {
    public static void mainMenu() throws ScriptException {
        int point = pointList();

        double EPS;
        switch (point) {
            case 0: {
                return;
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
        System.out.println("3.Вычеслить значение в т.x0 c помощью метода Лагранжа");
        System.out.println("4.Вычеслить значение в т.x0 c помощью метода Ньютона");
        return scanner.nextInt();
    }

    public static void main(String[] args) throws ScriptException {
        mainMenu();
    }
}
