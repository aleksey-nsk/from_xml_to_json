package transform_xml_to_json;

import com.google.gson.Gson;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

class DemoXmlToJson extends BaseClass {

  public static void main(String[] args) {
    System.out.println("\n***** Marshalling: Преобразование Java-объекта в XML-файл *****\n");

    Company bcsFromXml;

    // Создаём объект-Java
    Company bcs = new Company();
    bcs.setId(601);
    bcs.setName("БКС");
    bcs.setEmail("bcs@testemail.ru");
    bcs.setInn(112901);

    System.out.println("Преобразование Java-объекта в XML-файл");
    fromObjectToXml(bcs);

    /* try {
      File fileXml = new File("testfiles\\company.xml");
      JAXBContext context = JAXBContext.newInstance(Company.class);
      Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(bcs, fileXml);
      marshaller.marshal(bcs, System.out); // вывод на консоль
    } catch (JAXBException e) {
      Logger.getLogger(DemoXmlToJson.class.getName()).log(Level.SEVERE, null, e);
    } */

    // В результате получаем xml-файл

    // -------------------------------------------------------------------------------

    System.out.println("\n***** Unmarshalling: Преобразование XML-файла в Java-объект *****\n");

    try {
      File fileXml = new File("testfiles\\company.xml");
      JAXBContext context = JAXBContext.newInstance(Company.class);
      Unmarshaller unmarshaller = context.createUnmarshaller();
      bcsFromXml = (Company) unmarshaller.unmarshal(fileXml);
      System.out.println("bcsFromXml = ");
      System.out.println(bcsFromXml);
    } catch (JAXBException e) {
      Logger.getLogger(DemoXmlToJson.class.getName()).log(Level.SEVERE, null, e);
    }
    // В результате получаем Java-объект

    // -------------------------------------------------------------------------------

    System.out.println("\n***** Преобразование Java-объекта в JSON-файл *****\n");
    // Gson gson = new Gson();
    // String bcsToJsonString = gson.toJson(bcsFromXml);


  }
}
