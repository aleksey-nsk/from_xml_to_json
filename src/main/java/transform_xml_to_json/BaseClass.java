package transform_xml_to_json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

class BaseClass {

  // -------------------------------------------
  // Преобразование Java-объекта в XML-файл
  // -------------------------------------------
  protected static void fromObjectToXml(Company company) {
    try {
      File fileXml = new File("testfiles\\company.xml");
      JAXBContext context = JAXBContext.newInstance(Company.class);
      Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(company, fileXml);
      marshaller.marshal(company, System.out); // вывод на консоль
    } catch (JAXBException e) {
      Logger.getLogger(DemoXmlToJson.class.getName()).log(Level.SEVERE, null, e);
    }
  }
}
