package transform_xml_to_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class BaseClass {

  // -------------------------------------------
  // Объект для создания XML-файла
  // -------------------------------------------
  private static final File fileXml = new File("src\\main\\resources\\company.xml");

  // -------------------------------------------
  // Объект для создания JSON-файла
  // -------------------------------------------
  private static File companyJson = new File("src\\main\\resources\\company.json");
  private static final String absolutePathToFile = companyJson.getAbsolutePath(); // абсолютный путь к файлу
  private static final String FILENAME = absolutePathToFile;

  // -------------------------------------------
  // Преобразование Java-объекта в XML-файл
  // -------------------------------------------
  protected static void fromObjectToXml(Company company) {
    System.out.println("\n***** Метод для преобразования Java-объекта в XML-файл (НАЧАЛО) *****");
    try {
      JAXBContext context = JAXBContext.newInstance(Company.class);
      Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(company, fileXml);
      marshaller.marshal(company, System.out); // вывод на консоль
    } catch (JAXBException e) {
      Logger.getLogger(DemoXmlToJson.class.getName()).log(Level.SEVERE, null, e);
    }
    System.out.println("***** Метод для преобразования Java-объекта в XML-файл (КОНЕЦ) *****");
  }

  // -------------------------------------------
  // Преобразование XML-файла в Java-объект
  // -------------------------------------------
  protected static Company fromXmlToObject() throws JAXBException {
    System.out.println("\n***** Метод для преобразования XML-файла в Java-объект (НАЧАЛО) *****");
    JAXBContext context = JAXBContext.newInstance(Company.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    Company company = (Company) unmarshaller.unmarshal(fileXml);
    System.out.println("Java-объект, полученный из XML-файла:");
    System.out.println(company);
    System.out.println("***** Метод для преобразования XML-файла в Java-объект (КОНЕЦ) *****\n");
    return company;
  }

  // -------------------------------------------
  // Преобразование Java-объекта в JSON-файл
  // -------------------------------------------
  protected static void fromObjectToJson(Company company) {
    System.out.println("\n***** Метод для преобразования Java-объекта в JSON-файл (НАЧАЛО) *****");
    // Gson gson = new Gson();
    Gson gson = new GsonBuilder().setPrettyPrinting().create(); // красивый JSON-файл с отступами
    String jsonString = gson.toJson(company);
    System.out.println("Строка jsonString = " + jsonString);
    System.out.println("Запишем строку jsonString в JSON-файл");
    try (FileWriter fileWriter = new FileWriter(FILENAME)) {
      fileWriter.write(jsonString);
    } catch (IOException e) {
      Logger.getLogger(DemoXmlToJson.class.getName()).log(Level.SEVERE, null, e);
    }
    System.out.println("***** Метод для преобразования Java-объекта в JSON-файл (КОНЕЦ) *****");
  }
}
