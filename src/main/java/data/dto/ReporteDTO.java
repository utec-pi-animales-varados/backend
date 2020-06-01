package data.dto;

import data.entities.Animal;
import data.entities.Respuesta;
import data.entities.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class ReporteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Timestamp date;
    private Double latitude;
    private Double longitude;
    private List<String> picturesURLs = new ArrayList<>();
    private String comment;
    private Long usuarioid;
    private Long animalid;
    private Set<Respuesta> respuestas = new HashSet<>();
    private Double longitudAnimal;

    public ReporteDTO() {
    }

    public ReporteDTO(Long id, Timestamp date, Double latitude, Double longitude, List<String> picturesURLs, String comment, Long usuarioid, Long animalid, Set<Respuesta> respuestas, Double longitudAnimal) {
        this.id = id;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.picturesURLs = picturesURLs;
        this.comment = comment;
        this.usuarioid = usuarioid;
        this.animalid = animalid;
        this.respuestas = respuestas;
        this.longitudAnimal = longitudAnimal;
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

    public void setPicturesURLs(List<String> picturesURLs) {
        this.picturesURLs = picturesURLs;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Long usuarioid) {
        this.usuarioid = usuarioid;
    }

    public Long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(Long animalid) {
        this.animalid = animalid;
    }

    public Set<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(Set<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public Double getLongitudAnimal() {
        return longitudAnimal;
    }

    public void setLongitudAnimal(Double longitudAnimal) {
        this.longitudAnimal = longitudAnimal;
    }
}
