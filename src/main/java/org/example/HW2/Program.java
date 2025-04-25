package org.example.HW2;

//Используя Reflection API, напишите программу, которая выводит на экран все методы класса String.

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Program {
    public static void main(String[] args) {

        Method[] methods = String.class.getMethods();
//        Method[] declaredMethods = String.class.getDeclaredMethods();

        System.out.println("Все публичные методы класса String:");
        System.out.println("----------------------------------");

        for (Method method : methods) {
            String modifiers = Modifier.toString(method.getModifiers());
            Class<?> returnType = method.getReturnType();
            String methodName = method.getName();

            Class<?>[] paramTypes = method.getParameterTypes();
            StringBuilder params = new StringBuilder();
            for (int i = 0; i < paramTypes.length; i++) {
                params.append(paramTypes[i].getSimpleName());
                if (i < paramTypes.length - 1) {
                    params.append(", ");
                }
            }

            System.out.printf("%s %s %s(%s)%n",
                    modifiers,
                    returnType.getSimpleName(),
                    methodName,
                    params);
        }

        System.out.println("----------------------------------");
        System.out.println("Всего методов: " + methods.length);
    }
}
