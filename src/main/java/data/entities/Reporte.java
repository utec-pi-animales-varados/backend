package data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "reporte")
public class Reporte implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "reporte_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @ElementCollection
    @Column(name = "picturesURLs", nullable = false)
    private List<String> picturesURLs = new ArrayList<>();

    @Column(name = "comment")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @OneToMany(mappedBy = "reporte", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Respuesta> respuestas = new HashSet<>();

    @Column(name = "animal_longitud", nullable = false)
    private Double longitudAnimal;

    public Reporte(Timestamp date, Double longitud, Double latitude, Double longitude, List<String> picturesURLs, String comment, Usuario usuario, Animal animal, Set<Respuesta> respuestas) {
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.picturesURLs = picturesURLs;
        this.comment = comment;
        this.usuario = usuario;
        this.animal = animal;
        this.longitudAnimal = longitud;
        this.respuestas = respuestas;
    }

    public Reporte() {}

    public void setLongitudAnimal(Double longitud) {
        this.longitudAnimal = longitud;
    }

    public Double getLongitudAnimal() {
        return longitudAnimal;
    }

    public Set<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(Set<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
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

    public List<String> getPicturesURLs() {
        return picturesURLs;
    }

    public void setPicturesURLs(List<String> urlPicture) {
        this.picturesURLs = urlPicture;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

}
