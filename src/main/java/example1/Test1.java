package example1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {
  // Можно сразу писать new Gson(), вот так:
  // private static final Gson GSON = new Gson();
  // Но чтобы продемонстрировать красивый вывод с отступами,
  // воспользуемся GsonBuilder-ом:
  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

  public static void main(String[] args) {
    Person person1 = new Person("Вася", 30, Arrays.asList("Москва", "Новосибирск", "Омск"));

    System.out.println("***** Из объекта-Java в JSON-формат *****");
    // Сначала хотим получить строковое представление в JSON-формате нашего объекта-Java.
    // Для этого воспользуемся библиотекой gson.
    // Сначала определили private static final Gson GSON, а теперь:
    String jsonString = GSON.toJson(person1);
    System.out.println("jsonString = " + jsonString);

    System.out.println("***** Из JSON получим объект-Java *****");
    // Теперь продемонстрируем обратную конвертируемость, то есть
    // передадим json, и получим объект-Java:
    Person person2 = GSON.fromJson(jsonString, Person.class);
    System.out.println("person2 = " + person2); // person2 = example1.Person@4e718207
    System.out.println("person2.getName() = " + person2.getName());
    System.out.println("person2.getAge() = "  + person2.getAge());
    System.out.println("person2.getGeoHistory() = " + person2.getGeoHistory());
  }
}

// Опишем некий класс, объект которого
// в дальнейшем преобразуем в JSON-формат (и обратно):
class Person {
  private String name;
  private Integer age;
  // @SerializedName("geo")
  private List<String> geoHistory = new ArrayList<>(); // список строк где хранится геолокация

  public Person(String name, Integer age, List<String> geoHistory) {
    this.name = name;
    this.age = age;
    this.geoHistory = geoHistory;
  }

  // Методы геттеры:
  public String getName() { return name; }
  public Integer getAge() { return age; }
  public List<String> getGeoHistory() { return geoHistory; }
}
