package hiber.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User")
public class User {
   @OneToOne(mappedBy = "user")
   @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
   private Car car;
   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @NotEmpty(message="Name should not be empty")
   @Size(min = 2, max = 45, message = "Name should be 2 and 45 characters")
   @Column(name = "firstname")
   private String firstName;
   @NotEmpty(message="Lastname should not be empty")
   @Size(min = 2, max = 45, message = "Lastname should be 2 and 45 characters")
   @Column(name = "lastname")
   private String lastName;

   @Column(name = "email")
   @NotEmpty(message = "email should not be empty")
   @Email(message = "email should be valid")
   private String email;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
      car.setUser(this);
   }

   @Override
   public String toString() {
      return "User{" +
              "car model=" + car.model +
              ", id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              '}';
   }
}
