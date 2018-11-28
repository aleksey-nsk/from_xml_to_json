package example0_dont_work.entity;

public class Person {

  private String firstName;
  private String lastName;

  // Конструктор по умолчанию
  public Person() {
    //
  }

  // Геттеры и сеттеры
  public String getFirstName() { return firstName; }
  public void setFirstName(String firstName) { this.firstName = firstName; }
  public String getLastName() { return lastName; }
  public void setLastName(String lastName) { this.lastName = lastName; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Person person = (Person) o;

    if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
    return lastName != null ? lastName.equals(person.lastName) : person.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName .hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Person01{ " +
           "firstName='" + firstName + "\'" +
           ", lastName='" + lastName + "\'" +
           "}";
  }
}
