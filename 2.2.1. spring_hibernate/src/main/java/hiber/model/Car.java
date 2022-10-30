package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Car")
public class Car implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "series", referencedColumnName = "id")
    private User user;
    @Column(name = "model")
    String model;
    public Car() {
    }

    public Car(String model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
