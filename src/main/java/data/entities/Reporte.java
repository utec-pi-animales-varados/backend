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

    //@OneToMany(cascade = CascadeType.ALL, targetEntity = PreguntaYRespuesta.class)
    @OneToMany(mappedBy = "reporte")
    private Set<PreguntaYRespuesta> preguntaYRespuesta = new HashSet<>();

    /*@ManyToOne
    @JoinColumn(name="animal_id", nullable=true)
    private Animal animal;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable=true)
    private Usuario usuario;*/

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

    public Reporte(Set<PreguntaYRespuesta> preguntasYRespuestasSet, Animal animal, Usuario user, Date date, Double latitude, Double longitude, String urlPicture, String comment) {
        this.preguntaYRespuesta = preguntasYRespuestasSet;
        //this.animal = animal;
        //this.usuario = user;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.urlPicture = urlPicture;
        this.comment = comment;
    }

    public Reporte() {
    }

    public Set<PreguntaYRespuesta> getPreguntasYRespuestasSet() {
        return preguntaYRespuesta;
    }

    public void setPreguntasYRespuestasSet(Set<PreguntaYRespuesta> preguntasYRespuestasSet) {
        this.preguntaYRespuesta = preguntasYRespuestasSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public Usuario getUser() {
        return usuario;
    }

    public void setUser(Usuario user) {
        this.usuario = user;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }*/

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
