package transform_xml_to_json;

import javax.xml.bind.JAXBException;
import java.util.logging.Level;
import java.util.logging.Logger;

class DemoXmlToJson extends BaseClass {

  public static void main(String[] args) {
    System.out.println("Создаём объект-Java");
    Company bcs = new Company();
    bcs.setId(601);
    bcs.setName("БКС");
    bcs.setEmail("bcs@testemail.ru");
    bcs.setInn(112901);

    fromObjectToXml(bcs); // преобразование Java-объекта в XML-файл

    try {
      Company bcsFromXml = fromXmlToObject(); // преобразование XML-файла в Java-объект

      // Тут по заданию необходимо поменять несколько значений
      // у объекта

      fromObjectToJson(bcsFromXml); // преобразование Java-объекта в JSON-файл
    } catch (JAXBException e) {
      Logger.getLogger(DemoXmlToJson.class.getName()).log(Level.SEVERE, null, e);
    }
  }
}
