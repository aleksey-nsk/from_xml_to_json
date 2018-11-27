package example3;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JaxbExample {

  public static void main(String[] args) {
    // Создаём объект-Java
    Customer customer1 = new Customer();
    customer1.setId(1);
    customer1.setName("Вася Пупкин");
    customer1.setAge(22);

    // Для преобразования Java-объекта в XML-файл применяется метод Marshaller.marshal()
    // В классе Marshaller присутствует много перегруженных методов marshal() для
    // использования с разными типами объектов вывода информации
    try {
      File fileXml = new File("testfiles\\customer.xml");
      JAXBContext context = JAXBContext.newInstance(Customer.class);
      Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(customer1, fileXml);
      marshaller.marshal(customer1, System.out);
    } catch (JAXBException e) {
      Logger.getLogger(JaxbExample.class.getName()).log(Level.SEVERE, null, e);
    }
    // В результате получаем xml-файл:
    // <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    // <customer id="1">
    //   <age>22</age>
    //   <name>Вася Пупкин</name>
    // </customer>
  }
}
