package transform_xml_to_json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

class DemoXmlToJson {

  public static void main(String[] args) {
    System.out.println("\n***** Marshalling: Преобразование Java-объекта в XML-файл *****\n");

    // Создаём объект-Java
    Company bcs = new Company();
    bcs.setId(601);
    bcs.setName("БКС");
    bcs.setEmail("bcs@testemail.ru");
    bcs.setInn(112901);

    try {
      File fileXml = new File("testfiles\\company.xml");
      JAXBContext context = JAXBContext.newInstance(Company.class);
      Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(bcs, fileXml);
      marshaller.marshal(bcs, System.out); // вывод на консоль
    } catch (JAXBException e) {
      Logger.getLogger(DemoXmlToJson.class.getName()).log(Level.SEVERE, null, e);
    }

    // -------------------------------------------------------------------------------

    System.out.println("\n***** Unmarshalling: Преобразование XML-файла в Java-объект *****\n");

    try {
      File fileXml = new File("testfiles\\company.xml");
      JAXBContext context = JAXBContext.newInstance(Company.class);
      Unmarshaller unmarshaller = context.createUnmarshaller();
      Company bcsFromXml = (Company) unmarshaller.unmarshal(fileXml);
      System.out.println("bcsFromXml = ");
      System.out.println(bcsFromXml);
    } catch (JAXBException e) {
      Logger.getLogger(DemoXmlToJson.class.getName()).log(Level.SEVERE, null, e);
    }
  }
}
