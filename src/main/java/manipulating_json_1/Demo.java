package manipulating_json_1;

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
    System.out.println("\n***** Из объекта-Java в JSON-формат *****\n");
    Person person1 = new Person("Вася", 30, Arrays.asList("Москва", "Новосибирск", "Омск"));

    // Сначала хотим получить строковое представление в JSON-формате нашего объекта-Java.
    // Для этого воспользуемся библиотекой gson.
    // Выше уже определили private static final Gson GSON, а теперь:
    String jsonString = GSON.toJson(person1);

    System.out.println("jsonString = " + jsonString);

    // -------------------------------------------------------------------

    System.out.println("\n***** Из JSON получим объект-Java *****\n");

    // Теперь продемонстрируем обратную конвертируемость, то есть
    // передадим json, и получим объект-Java:
    Person person2 = GSON.fromJson(jsonString, Person.class);

    System.out.println("person2 = " + person2); // person2 = manipulating_json_1.Person@4e718207
    System.out.println("person2.getName() = " + person2.getName());
    System.out.println("person2.getAge() = "  + person2.getAge());
    System.out.println("person2.getGeoHistory() = " + person2.getGeoHistory());
  }
}
