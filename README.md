## Задача: преобразовать XML-файл в JSON-файл
1. Создаём Java-объект
2. Преобразуем Java-объект в XML-файл
3. Преобразуем XML-файл в Java-объект
4. Поменяем несколько значений у Java-объекта
5. Преобразуем Java-объект в JSON-файл

#### Info: 
- Для работы с JSON использую **библиотеку gson**
- Для работы с XML использую **библиотеку JAXB**
- Реализовал вложенность тегов в xml-сообщении
- Добавил атрибут xml тегу
- Company, Phone -- классы для создания Java-объекта
- BaseClass -- содержит методы: 
  - fromObjectToXml( )
  - fromXmlToObject( )
  - fromObjectToJson( )
- Класс DemoXmlToJson -- содержит решение задачи
- В папке `src/main/resources` находятся файлы company.xml и company.json
- Создал песочницу `src/main/java/sandbox` чтобы поразбираться, как работать с xml и json
