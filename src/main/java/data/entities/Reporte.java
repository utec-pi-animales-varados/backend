package data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reporte")
public class Reporte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = PreguntaYRespuesta.class)
    @JoinColumn(name = "id_preguntayrespuesta")
    private Set<PreguntaYRespuesta> preguntasYRespuestasSet = new HashSet<>();

    @ManyToOne
    private Usuario user;

    @ManyToOne
    private Animal animal;

    @Column
    private Date date;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column
    private String urlPicture;

    @Column
    private String comment;

    public Reporte(Usuario user, Animal animal, Date date, Double latitude, Double longitude, String urlPicture, String comment) {
        this.user = user;
        this.animal = animal;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.urlPicture = urlPicture;
        this.comment = comment;
    }

    public Reporte() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
