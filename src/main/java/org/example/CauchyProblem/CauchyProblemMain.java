package org.example.CauchyProblem;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;

import javax.script.ScriptException;
import java.awt.*;
import java.util.List;
import java.util.Map;

import static org.example.CauchyProblem.ErrorMethods.*;
import static org.example.CauchyProblem.FunctionTwoVariables.writeFunctionTwoVariables;
import static org.example.CauchyProblem.FunctionTwoVariables.writeY;
import static org.example.CauchyProblem.MethodsSolvingCauchyProblem.EulerMethod.euler;
import static org.example.CauchyProblem.MethodsSolvingCauchyProblem.ModifiedEulerMethod.modifiedEuler;
import static org.example.CauchyProblem.MethodsSolvingCauchyProblem.RungeKutta4Method.rungeKutta4;
import static org.example.GlobalClasses.AuxiliaryFunctions.*;


/**
 * @author Vladislav Osada
 * @date 18.05.2023 22:15
 */

public class CauchyProblemMain {
    static List<Double> solution;
    private static final String functionString = writeFunctionTwoVariables();
    private static final double[] limits = setLimits();

    private static final double h = inputDouble("Введите значение шага h:");

    private static double y0 = writeY(limits[0]);

    public static void main(String[] args) throws ScriptException {

        // Значения для первого метода
        Map<String, List<Double>> resultEuler = euler(functionString, limits, h, y0);
        List<Double> x1 = resultEuler.get("x1");
        List<Double> y1 = resultEuler.get("y1");

// Значения для второго метода
        Map<String, List<Double>> resultModifiedEuler = modifiedEuler(functionString, limits, h, y0);
        List<Double> x2 = resultModifiedEuler.get("x1");
        List<Double> y2 = resultModifiedEuler.get("y1");

// Значения для третьего метода
        Map<String, List<Double>> resultRungeKutta4 = rungeKutta4(functionString, limits, h, y0);
        List<Double> x3 = resultRungeKutta4.get("x1");
        List<Double> y3 = resultRungeKutta4.get("y1");

        // Вывод результатов
        System.out.println("Метод Эйлера:");
        printResults(resultEuler);

        System.out.println("Улучшенный метод Эйлера:");
        printResults(resultModifiedEuler);

        System.out.println("Метод Рунге-Кутты 4го порядка:");
        printResults(resultRungeKutta4);

        // Расчет погрешности для метода Эйлера
        double eulerError = calculateEulerError(functionString, limits, h, y0);
        System.out.println("Погрешность метода Эйлера: " + eulerError);

        // Расчет погрешности для усовершенствованного метода Эйлера
        double modifiedEulerError = calculateModifiedEulerError(functionString, limits, h, y0);
        System.out.println("Погрешность усовершенствованного метода Эйлера: " + modifiedEulerError);

        // Расчет погрешности для метода Рунге-Кутты 4-го порядка
        double rungeKutta4Error = calculateRungeKutta4Error(functionString, limits, h, y0);
        System.out.println("Погрешность метода Рунге-Кутты 4-го порядка: " + rungeKutta4Error);

        // Создание датасета
        DefaultXYDataset dataset = new DefaultXYDataset();
        dataset.addSeries("Метод Эйлера", new double[][]{toArray(x1), toArray(y1)});
        dataset.addSeries("Улучшенный метод Эйлера", new double[][]{toArray(x2), toArray(y2)});
        dataset.addSeries("Метод Рунге-Кутты 4го порядка:", new double[][]{toArray(x3), toArray(y3)});

        // Создание графика
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Graph", // Заголовок графика
                "X", // Метка оси X
                "Y", // Метка оси Y
                dataset, // Датасет с данными
                PlotOrientation.VERTICAL, // Ориентация графика
                true, // Легенда
                true, // Tooltips
                false // URL-ссылки
        );

        // Установка разных цветов для каждой серии данных
        chart.getXYPlot().getRenderer().setSeriesPaint(0, Color.RED);
        chart.getXYPlot().getRenderer().setSeriesPaint(1, Color.GREEN);
        chart.getXYPlot().getRenderer().setSeriesPaint(2, Color.BLUE);


        // Отображение графика в окне
        ChartFrame frame = new ChartFrame("Chart", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
