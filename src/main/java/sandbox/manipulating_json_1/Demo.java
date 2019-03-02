package sandbox.manipulating_json_1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Arrays;

class Demo {

  // Можно сразу писать new Gson(), вот так:
  // private static final Gson GSON = new Gson();
  //
  // Но чтобы продемонстрировать красивый вывод с отступами,
  // воспользуемся GsonBuilder-ом:
  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

  public static void main(String[] args) {
    System.out.println("\n***** Из Java-объекта в JSON-формат *****\n");
    Person person1 = new Person("Вася", 30, Arrays.asList("Москва", "Новосибирск", "Омск"));

    // Сначала хотим получить строковое представление в JSON-формате нашего Java-объекта
    // Для этого воспользуемся библиотекой gson
    // Выше уже определили private static final Gson GSON, а теперь:
    String jsonString = GSON.toJson(person1);

    System.out.println("jsonString = \n" + jsonString);

    /* ------------------------------------------------------------------- */

    System.out.println("\n***** Из JSON получим Java-объект *****\n");

    // Теперь продемонстрируем обратную конвертируемость, то есть
    // передадим JSON, и получим Java-объект:
    Person person2 = GSON.fromJson(jsonString, Person.class);

    System.out.println(person2.getName()); // Вася
    System.out.println(person2.getAge()); // 30
    System.out.println(person2.getGeoHistory()); // [Москва, Новосибирск, Омск]
  }
}
