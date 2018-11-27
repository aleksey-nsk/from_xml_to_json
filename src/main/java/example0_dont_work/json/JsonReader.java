package example0_dont_work.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import example0_dont_work.entity.Person;

// Берём ObjectMapper из пакета:

import java.util.ArrayList;
import java.util.List;

// -------------------------------------------------------------------------
// Использую Jackson
//
// В классе будет только 1 метод
/* public class JsonReader {

  // Метод принимает в качестве параметра json как строку
  // Метод возвращает List Person-ов
  public List<Person> getPersons(String json) {
    ObjectMapper mapper = new ObjectMapper();
    List<Person> methodList = new ArrayList<>();
    try {
      // methodList = Arrays.asList(mapper.readValue(json, Person[].class));

      // Вызываем метод readValue() в который передаём
      // json и массив
      Person[] arrayPerson = mapper.readValue(json, Person[].class);
      // Преобразуем array_Персонов в List_Персонов:
      methodList = Arrays.asList(arrayPerson);
    } catch (IOException e) {
      System.out.println(e);
    }
    return methodList;
  }
} */
// -------------------------------------------------------------------------
// Использую gson (от Google)
//
public class JsonReader {

  // Данный метод будет мапить наш json на объекты класса Person
  public List<Person> getPersons(String json) {
    Gson gson = new Gson();
    // Есть методы:
    //   fromJson() -- чтобы мапить json на объекты Java
    //   toJson() ---- чтобы мапить объект в json
    //
    // Вызываем метод fromJson()
    //   1-ый параметр -- наш строковый json
    //   2-ой параметр -- List_Персонов_в_TypeToken
    // return gson.fromJson(json, new TypeToken<List<Person>>(){}.getType());
    List<Person> listPersons = new ArrayList<>();
    listPersons = gson.fromJson(json, new TypeToken<List<Person>>(){}.getType());
    return listPersons;
    // Person person = gson.fromJson(json, Person.class);
    // return (List<Person>) person;
  }
}
