package data.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "pyq")
public class PreguntaYRespuesta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String answer;

    @ManyToOne
    @JoinColumn(name="reporte_id", nullable=true)
    private Reporte reporte;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pregunta_id", referencedColumnName = "id")
    private Pregunta pregunta;

    public PreguntaYRespuesta() {
    }

    public PreguntaYRespuesta(String answer, Reporte report, Pregunta pregunta) {
        this.answer = answer;
        this.reporte = report;
        this.pregunta = pregunta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setReport(Reporte report) {
        this.reporte = report;
    }

    public Long getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public Reporte getReport() {
        return reporte;
    }
}
