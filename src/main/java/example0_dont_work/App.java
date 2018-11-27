package example0_dont_work;

import example0_dont_work.entity.Person;
import example0_dont_work.json.JsonReader;

import java.util.List;

public class App {

  public static void main(String[] args) {
    JsonReader reader = new JsonReader(); // экземпляр класса JsonReader

    // json
    String json = "{ \n" +
        "  { \n" +
        "    \"firstName\":\"Вася\", \n" +
        "    \"lastName\":\"Пупкин\" \n" +
        "  }, \n" +
        "  { \n" +
        "    \"firstName\":\"Петя\", \n" +
        "    \"lastName\":\"Сидоров\" \n" +
        "  }\n" +
        "}";
    System.out.println("json = " + json);

    // Создаём personList
    List<Person> personList = reader.getPersons(json);
    System.out.println("personList = " + personList);
    // Может просто Person создаём
    // Person person = (Person) reader.getPersons(json);

    // Выводим результат в консоль (List из 2-ух Person-ов)
    for (Person person : personList) {
      System.out.println("person = " + person);
    }
    // -- резултат:
    // Person{firstName='Вася', lastName='Пупкин'}
    // Person{firstName='Петя', lastName='Сидоров'}
  }
}
