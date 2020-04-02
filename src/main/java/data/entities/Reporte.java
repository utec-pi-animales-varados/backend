package data.entities;

import jdk.jfr.Relational;
import org.springframework.data.mapping.PersistentEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "reporte")
public class Reporte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario user;

    @ManyToOne
    private Animal animal;

    @Column
    private Time time;

    @Column
    private String coordinates;

    @Column
    private String pictureURL;

    @Column
    private String comment;

    public Reporte(Usuario user, Animal animal, Time time, String coordinates, String pictureURL, String comment) {
        this.user = user;
        this.animal = animal;
        this.time = time;
        this.coordinates = coordinates;
        this.pictureURL = pictureURL;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
