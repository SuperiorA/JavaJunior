package org.example.HW3;

//Задание 1: Создайте класс Person с полями name и age. Реализуйте сериализацию и десериализацию этого класса в файл.

//Задание 2: Используя JPA, создайте базу данных для хранения объектов класса Person.
// Реализуйте методы для добавления, обновления и удаления объектов Person

import java.io.*;

public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Person human1 = new Person("Вася", 20);
//
//        FileOutputStream fileOutputStream = new FileOutputStream("Doc.txt");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(human1);
//        objectOutputStream.close();
//        System.out.println("Объект сериализован");
//
//        FileInputStream fileInputStream = new FileInputStream("Doc.txt");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        Person human1Back = (Person) objectInputStream.readObject();
//        System.out.println(human1Back.toString());
//        System.out.println("Объект десериализован");

        System.out.println("Запуск программы через JPA API");

        PersonDAO dao = new PersonDAO();
        try {

            Person person = new Person("Иван", 30);
            Person person1 = new Person("Мотя", 79);
            dao.addPerson(person);
            dao.addPerson(person1);
            System.out.println("Успешно добавлен: " + person);
            System.out.println("Успешно добавлен: " + person1);

            Person foundPerson = dao.getPersonById(person.getId());
            foundPerson.setAge(31);
            dao.updatePerson(foundPerson);
            System.out.println("Обновлён: " + foundPerson);

            dao.deletePerson(person1.getId());
            System.out.println("Удалён человек с id = " + person1.getId());

        }

        finally {
            dao.close();
            System.out.println("Программа завершена");
        }
    }
}
