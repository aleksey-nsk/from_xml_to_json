package transform_xml_to_json;

import javax.xml.bind.JAXBException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static transform_xml_to_json.Company.createCompany;
import static transform_xml_to_json.Phone.createPhone;

class DemoXmlToJson extends BaseClass {


  public static void main(String[] args) {
    System.out.println("Создаём Java-объект");
    Company bcs = createCompany(601, "БКС", "bcs@testemail.ru", 112901, "Россия");
    bcs.getPhone().add(createPhone("Мобильный", "+7(383)", "220-99-00"));
    bcs.getPhone().add(createPhone("Факс", "+7(666)", "333-88-44"));


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
