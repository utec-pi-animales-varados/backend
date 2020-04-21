package data.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "preguntayrespuesta")
public class PreguntaYRespuesta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String answer;

    @ManyToOne
    private Reporte report;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pregunta_id", referencedColumnName = "id")
    private Pregunta pregunta;

    public PreguntaYRespuesta() {
    }

    public PreguntaYRespuesta(String answer, Reporte report, Pregunta pregunta) {
        this.answer = answer;
        this.report = report;
        this.pregunta = pregunta;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setReport(Reporte report) {
        this.report = report;
    }

    public Long getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public Reporte getReport() {
        return report;
    }
}
