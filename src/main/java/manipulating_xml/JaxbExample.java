package manipulating_xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

class JaxbExample {

  public static void main(String[] args) {
    System.out.println("\n***** Marshalling: Преобразование Java-объекта в XML-файл *****\n");

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

    System.out.println("\nXML-файл записан");
    // В результате получаем xml-файл customer.xml:
    // <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    // <customer id="1">
    //   <age>22</age>
    //   <name>Вася Пупкин</name>
    // </customer>

    // --------------------------------------------------------------------------

    System.out.println("\n***** Unmarshalling: Преобразование XML-файла в Java-объект *****\n");

    // Выполним обратную операцию: преобразуем XML-файл в Java объект.
    // Это делается с помощью метода Unmarshaller.unmarshal()
    // В классе Unmarshaller есть много перегруженных методов unmarshal()
    // которые решают большинство распространенных случаев использования
    try {
      File fileXml = new File("testfiles\\customer.xml");
      JAXBContext context = JAXBContext.newInstance(Customer.class);
      Unmarshaller unmarshaller = context.createUnmarshaller();
      Customer customer2 = (Customer) unmarshaller.unmarshal(fileXml);
      System.out.println("customer2 = " + customer2);
    } catch (JAXBException e) {
      Logger.getLogger(JaxbExample.class.getName()).log(Level.SEVERE, null, e);
    }
    // В результате получаем Java-объект
    // Customer [name=Вася Пупкин, id=1, age=22]
  }
}