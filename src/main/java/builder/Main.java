package builder;

import lombok.Getter;
import lombok.ToString;

public class Main {
  public static void main(String[] args) {
    Person person = Person.builder()
        .setFirstName("Василий")
        .setLastName("Иванов")
        .setMiddleName("Сергеевич")
        .build();
    System.out.println(person);
  }
}

@Getter
@ToString
class Person {

  private String firstName;
  private String lastName;
  private String middleName;
//  ...

  private Person() {
  }

  public static Person.Builder builder() {
    return new Person().new Builder();
  }

  public class Builder {

    private Builder() {
    }

    public Person.Builder setLastName(String lastName) {
      Person.this.lastName = lastName;
      return this;
    }

    public Person.Builder setFirstName(String firstName) {
      Person.this.firstName = firstName;
      return this;
    }

    public Person.Builder setMiddleName(String middleName) {
      Person.this.middleName = middleName;
      return this;
    }

//    ...

    public Person build() {
      return Person.this;
    }
  }
}
