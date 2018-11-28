package transform_xml_to_json;

import com.google.gson.Gson;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    File fileXml = new File("testfiles\\company.xml");

    fromObjectToXml(bcs, fileXml); // преобразование Java-объекта в XML-файл

    try {
      Company bcsFromXml = fromXmlToObject(fileXml); // преобразование XML-файла в Java-объект

      // Преобразование Java-объекта в JSON-файл
      fromObjectToJson(bcsFromXml); // преобразование Java-объекта в JSON-файл
      /* System.out.println("Преобразование Java-объекта в JSON-файл");
      Gson gson = new Gson();
      String bcsToJsonString = gson.toJson(bcsFromXml);
      System.out.println("bcsToJsonString = " + bcsToJsonString);
      System.out.println("Запишем строку bcsToJsonString в файл");
      try (FileWriter fileWriter = new FileWriter(FILENAME)) {
        fileWriter.write(bcsToJsonString);
      } catch (IOException e) {
        Logger.getLogger(DemoXmlToJson.class.getName()).log(Level.SEVERE, null, e);
      } */


    } catch (JAXBException e) {
      Logger.getLogger(DemoXmlToJson.class.getName()).log(Level.SEVERE, null, e);
    }


  }
}
