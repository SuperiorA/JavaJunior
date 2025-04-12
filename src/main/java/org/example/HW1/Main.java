package org.example.HW1;

//Напишите программу, которая использует Stream API для обработки списка чисел.
// Программа должна вывести на экран среднее значение всех четных чисел в списке.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1,-4,3,4,5,6,7,-8,9,-10));

        OptionalDouble average = list.stream().
                filter(a -> a % 2 == 0)
                .mapToInt(Integer::intValue)
                .average();
        double averageDouble = average.getAsDouble();

        if (averageDouble == 0) {
            System.out.println("Нет четных числе в массиве");
        }
        else {
            System.out.println("Среднее значение всех четных чисел в массиве = " + averageDouble);
        }
    }
}