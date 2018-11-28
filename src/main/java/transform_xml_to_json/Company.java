package transform_xml_to_json;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"id", "name", "email", "inn", "members"})
@XmlRootElement
class Company {

  private int id;
  private String name;
  private String email;
  private int inn;
  private List<Person> members = new ArrayList<Person>();

  // Методы сеттеры
  @XmlElement
  public void setId(int id) { this.id = id; }
  @XmlElement
  public void setName(String name) { this.name = name; }
  @XmlElement
  public void setEmail(String email) { this.email = email; }
  @XmlElement
  public void setInn(int inn) { this.inn = inn; }

  @XmlElementWrapper(name="memberwrapper")
  @XmlElement
  public void setMembers(List<Person> members) { this.members = members; }

  // Методы геттеры
  public int getId() { return id; }
  public String getName() { return name; }
  public String getEmail() { return email; }
  public int getInn() { return inn; }
  public List<Person> getMembers() { return members; }

  // Подправить !!!!!!!!!
  @Override
  public String toString() {
    return "  Company [id=" + id + ",\n"
         + "    name=" + name + ",\n"
         + "    email=" + email + ",\n"
         + "    inn=" + inn + "]";
  }
}
