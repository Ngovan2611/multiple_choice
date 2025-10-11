package haui.csn.thitot.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Integer answerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "is_correct", length = 10)
    private String isCorrect;

    @Column(name = "answer_a", length = 255)
    private String answerA;

    @Column(name = "answer_b", length = 255)
    private String answerB;

    @Column(name = "answer_c", length = 255)
    private String answerC;

    @Column(name = "answer_d", length = 255)
    private String answerD;



    // Constructor không tham số (bắt buộc cho JPA)
    public Answer() {
    }

    // Getter và Setter

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }
}
