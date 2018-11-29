package transform_xml_to_json;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"type", "code", "number"})
class Phone {

  private String type;
  private String code;
  private String number;

  // Методы сеттеры
  @XmlElement public void setType(String type) { this.type = type; }
  @XmlElement public void setCode(String code) { this.code = code; }
  @XmlElement public void setNumber(String number) { this.number = number; }

  // Методы геттеры
  public String getType() { return type; }
  public String getCode() { return code; }
  public String getNumber() { return number; }

  public static Phone createPhone(String type, String code, String number) {
    Phone phone = new Phone();
    phone.setType(type);
    phone.setCode(code);
    phone.setNumber(number);
    return phone;
  }
}
