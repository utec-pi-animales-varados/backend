package data.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "pregunta")
public class Pregunta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String questionText;

    @OneToOne(mappedBy = "pregunta")
    private PreguntaYRespuesta preguntaYRespuesta;

    public Pregunta() {
    }

    public Pregunta(String questionText, PreguntaYRespuesta preguntaYRespuesta) {
        this.questionText = questionText;
        this.preguntaYRespuesta = preguntaYRespuesta;
    }

    public Long getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}
