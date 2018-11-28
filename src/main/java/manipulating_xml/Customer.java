package manipulating_xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Customer {

  private String name;
  private int age;
  private int id;

  // Методы сеттеры
  @XmlElement
  public void setName(String name) { this.name = name; }
  @XmlElement
  public void setAge(int age) { this.age = age; }
  @XmlAttribute
  public void setId(int id) { this.id = id; }

  // Методы геттеры
  public String getName() { return name; }
  public int getAge() { return age; }
  public int getId() { return id; }

  @Override
  public String toString() {
    return "Customer [name=" + name + ", id=" + id +", age=" + age + "]";
  }
}
