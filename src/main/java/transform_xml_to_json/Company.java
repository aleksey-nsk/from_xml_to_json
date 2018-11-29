package transform_xml_to_json;

import com.google.gson.annotations.SerializedName;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"name", "email", "inn", "phone", "country", "city"})
@XmlRootElement
class Company {

  private int id;
  private String name;
  private String email;
  private int inn;
  @SerializedName("phones")
  private List<Phone> phone = new ArrayList<>();
  private String country;
  private String city;

  // Методы сеттеры
  //@XmlElement
  @XmlAttribute
  public void setId(int id) { this.id = id; }
  @XmlElement
  public void setName(String name) { this.name = name; }
  @XmlElement
  public void setEmail(String email) { this.email = email; }
  @XmlElement
  public void setInn(int inn) { this.inn = inn; }
  @XmlElementWrapper(name="phones")
  @XmlElement
  public void setPhone(List<Phone> phone) { this.phone = phone; }
  @XmlElement
  public void setCountry(String country) { this.country = country; }
  @XmlElement
  public void setCity(String city) { this.city = city; }

  // Методы геттеры
  public int getId() { return id; }
  public String getName() { return name; }
  public String getEmail() { return email; }
  public int getInn() { return inn; }
  public List<Phone> getPhone() { return phone; }
  public String getCountry() { return country; }
  public String getCity() { return city; }

  public static Company createCompany(int id, String name, String email, int inn, String country, String city) {
    Company company = new Company();
    company.setId(id);
    company.setName(name);
    company.setEmail(email);
    company.setInn(inn);
    company.setCountry(country);
    company.setCity(city);
    return company;
  }

  // Подправить !!!!!!!!!
  @Override
  public String toString() {
    return "  Company [id=" + id + ",\n"
         + "    name=" + name + ",\n"
         + "    email=" + email + ",\n"
         + "    inn=" + inn + "]";
  }
}
