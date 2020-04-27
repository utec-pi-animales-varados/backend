package data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "respuesta")
@JsonIgnoreProperties({"hibernateLazyInitialize", "handler"})
public class Respuesta implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String textoRespuesta;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporte_id")
    private Reporte reporte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pregunta_id")
    private Pregunta pregunta;

    public Respuesta(String textoRespuesta, Reporte reporte, Pregunta pregunta) {
        this.textoRespuesta = textoRespuesta;
        this.reporte = reporte;
        this.pregunta = pregunta;
    }

    public Respuesta() {
    }

    @JsonIgnore
    public Reporte getReporte() {
        return reporte;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    @JsonProperty
    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }

    public String getTextoRespuesta() {
        return textoRespuesta;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
