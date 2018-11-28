package manipulating_json_1;

import java.util.ArrayList;
import java.util.List;

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
