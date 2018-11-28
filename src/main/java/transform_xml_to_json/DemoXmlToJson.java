package transform_xml_to_json;

import javax.xml.bind.JAXBException;
import java.util.logging.Level;
import java.util.logging.Logger;

class DemoXmlToJson extends BaseClass {

  public static Person createPerson(String lastName, String firstName, int age) {
    Person person = new Person();
    person.setLastName(lastName);
    person.setFirstName(firstName);
    person.setAge(age);
    return person;
  }

  public static void main(String[] args) {
    System.out.println("Создаём объект-Java");
    Company bcs = new Company();
    bcs.setId(601);
    bcs.setName("БКС");
    bcs.setEmail("bcs@testemail.ru");
    bcs.setInn(112901);

    bcs.getMembers().add(createPerson("Иванов", "Иван", 21));
    bcs.getMembers().add(createPerson("Сидоров", "Сидор", 33));




    fromObjectToXml(bcs); // преобразование Java-объекта в XML-файл

    try {
      Company bcsFromXml = fromXmlToObject(); // преобразование XML-файла в Java-объект

      // Тут по заданию необходимо поменять несколько значений у объекта
      bcsFromXml.setName("ООО Компания БрокерКредитСервис"); // поменял название
      bcsFromXml.setEmail("new_email_bcs@testemail.ru"); // поменял email

      fromObjectToJson(bcsFromXml); // преобразование Java-объекта в JSON-файл
    } catch (JAXBException e) {
      Logger.getLogger(DemoXmlToJson.class.getName()).log(Level.SEVERE, null, e);
    }
  }
}
