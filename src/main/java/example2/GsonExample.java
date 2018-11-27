/*
В рассмотренном ниже примере мы создадим объект типа DataObject
и запишем его JSON представление в файл file.json
*/

package example2;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GsonExample {
  private static File fileJson = new File("testfiles\\file.json");
  private static final String absolutePathToFile = fileJson.getAbsolutePath(); // абсолютный путь к файлу начиная с корня системы
  private static final String FILENAME = absolutePathToFile;

  public static void main(String[] args) {
    DataObject object1 = new DataObject();
    Gson gson = new Gson();
    String jsonString = gson.toJson(object1);
    try (FileWriter fileWriter = new FileWriter(FILENAME)) {
      fileWriter.write(jsonString);
    } catch (IOException e) {
      Logger.getLogger(GsonExample.class.getName()).log(Level.SEVERE, null, e);
    }
    // В результате создан файл file.json с содержимым
    // {"data1":"Some value","data2":123,"list":["List item 1","List item 2","List item 3"]}
  }
}
