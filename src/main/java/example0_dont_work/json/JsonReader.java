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
  // Метод возвращает List Person01-ов
  public List<Person01> getPersons(String json) {
    ObjectMapper mapper = new ObjectMapper();
    List<Person01> methodList = new ArrayList<>();
    try {
      // methodList = Arrays.asList(mapper.readValue(json, Person01[].class));

      // Вызываем метод readValue() в который передаём
      // json и массив
      Person01[] arrayPerson = mapper.readValue(json, Person01[].class);
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

  // Данный метод будет мапить наш json на объекты класса Person01
  public List<Person> getPersons(String json) {
    Gson gson = new Gson();
    // Есть методы:
    //   fromJson() -- чтобы мапить json на объекты Java
    //   toJson() ---- чтобы мапить объект в json
    //
    // Вызываем метод fromJson()
    //   1-ый параметр -- наш строковый json
    //   2-ой параметр -- List_Персонов_в_TypeToken
    // return gson.fromJson(json, new TypeToken<List<Person01>>(){}.getType());
    List<Person> listPersons = new ArrayList<>();
    listPersons = gson.fromJson(json, new TypeToken<List<Person>>(){}.getType());
    return listPersons;
    // Person01 person = gson.fromJson(json, Person01.class);
    // return (List<Person01>) person;
  }
}
