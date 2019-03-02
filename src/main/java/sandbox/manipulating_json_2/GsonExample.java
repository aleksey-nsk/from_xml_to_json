package sandbox.manipulating_json_2;

import com.google.gson.Gson;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class GsonExample {

  private static File fileJson = new File("src\\main\\resources\\file.json");
  private static final String absolutePathToFile = fileJson.getAbsolutePath(); // абсолютный путь к файлу
  private static final String FILENAME = absolutePathToFile;

  public static void main(String[] args) {
    System.out.println("Создадим объект типа DataObject, и его JSON-представление");
    DataObject object1 = new DataObject();
    Gson gson = new Gson();
    String jsonString = gson.toJson(object1);
    System.out.println("  jsonString = " + jsonString);

    System.out.println("\nЗапишем строку jsonString в файл file.json");
    try (FileWriter fileWriter = new FileWriter(FILENAME)) {
      fileWriter.write(jsonString);
    } catch (IOException e) {
      Logger.getLogger(GsonExample.class.getName()).log(Level.SEVERE, null, e);
    }
    // В результате создан файл file.json с содержимым
    // {"data1":"Some value","data2":123,"list":["List item 1","List item 2","List item 3"]}

    /* ------------------------------------------------------------------------ */

    // Теперь для преобразования полученной на предыдущем шаге JSON-строки
    // обратно в Java-объект воспользуемся методом fromJson()
    System.out.println("\nПреобразуем JSON-строку в Java-объект");
    try {
      BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
      DataObject object2 = gson.fromJson(reader, DataObject.class);
      System.out.println("  в результате получаем Java-объект");
      System.out.println("  " + object2); // [DataObject: data1=Some value, data2=123, list=[List item 1, List item 2, List item 3]]
    } catch (FileNotFoundException e) {
      Logger.getLogger(GsonExample.class.getName()).log(Level.SEVERE, null, e);
    }
  }
}
