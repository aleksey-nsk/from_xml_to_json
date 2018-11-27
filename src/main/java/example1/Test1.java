package example1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {
  // можно сразу писать new Gson()
  // private static final Gson GSON = new Gson();
  // чтобы продемонстрировать красивый вывод с отступами, воспользуемся
  // GsonBuilder-ом
  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

  public static void main(String[] args) {
    Person person = new Person("Вася", 30, Arrays.asList("Москва", "Новосибирск", "Омск"));

    // Теперь хотим получить строковое представление в JSON-формате нашего объекта
    // Для этого воспользуемся библиотекой gson
    // Сначала определили private static final Gson GSON
    // Теперь:
    String json = GSON.toJson(person);
    System.out.println(json);

    // ПРОДЕМОНСТРИРУЕМ ОБРАТНУЮ КОНВЕРТИРУЕМОСТЬ
    // Передадим json -- получим объект Java:
    Person person1 = GSON.fromJson(json, Person.class);
    System.out.println("person1 = " + person1);
    System.out.println("person1.getName() = " + person1.getName());
    System.out.println("person1.getAge() = "  + person1.getAge());
    System.out.println("person1.getGeoHistory() = " + person1.getGeoHistory());
  }
}

// Опишем некий класс, который в дальнейшем
// преобразуем в JSON
class Person {
  private String name;
  private Integer age;
  @SerializedName("geo")
  private List<String> geoHistory = new ArrayList<>(); // список строк где хранится геолокация

  public Person(String name, Integer age, List<String> geoHistory) {
    this.name = name;
    this.age = age;
    this.geoHistory = geoHistory;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public List<String> getGeoHistory() {
    return geoHistory;
  }
}
