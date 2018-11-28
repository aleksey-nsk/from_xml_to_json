package transform_xml_to_json;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"lastName", "firstName", "age"})
class Person {

  private String lastName;
  private String firstName;
  private int age;

  @XmlElement
  public void setLastName(String lastName) { this.lastName = lastName; }
  @XmlElement
  public void setFirstName(String firstName) { this.firstName = firstName; }
  @XmlElement
  public void setAge(int age) { this.age = age; }

  public String getLastName() { return lastName; }
  public String getFirstName() { return firstName; }
  public int getAge() { return age; }
}
