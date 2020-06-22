package data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "pregunta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pregunta implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pregunta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "texto")
    private String texto;

    @Column(name = "prioridad", unique=true)
    private Short prioridad;

    @JsonIgnore
    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Respuesta> respuestas = new HashSet<>();

    public Pregunta() {
    }

    public Pregunta(Long id, String texto, Short prioridad, Set<Respuesta> respuestas) {
        this.id = id;
        this.texto = texto;
        this.prioridad = prioridad;
        this.respuestas = respuestas;
    }

    public void setRespuestas(Set<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public Set<Respuesta> getRespuestas() {
        return respuestas;
    }

    public Long getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrioridad(Short prioridad) {
        this.prioridad = prioridad;
    }

    public Short getPrioridad() {
        return prioridad;
    }

    public void setTexto(String questionText) {
        this.texto = questionText;
    }
}
