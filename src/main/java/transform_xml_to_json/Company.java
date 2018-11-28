package transform_xml_to_json;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Company {

  private int id;
  private String name;
  private String email;
  private int inn;

  // Методы сеттеры
  @XmlElement
  public void setId(int id) { this.id = id; }
  @XmlElement
  public void setName(String name) { this.name = name; }
  @XmlElement
  public void setEmail(String email) { this.email = email; }
  @XmlElement
  public void setInn(int inn) { this.inn = inn; }

  // Методы геттеры
  public int getId() { return id; }
  public String getName() { return name; }
  public String getEmail() { return email; }
  public int getInn() { return inn; }

  @Override
  public String toString() {
    return "  Company [id=" + id + ",\n"
         + "    name=" + name + ",\n"
         + "    email=" + email + ",\n"
         + "    inn=" + inn + "]";
  }
}
