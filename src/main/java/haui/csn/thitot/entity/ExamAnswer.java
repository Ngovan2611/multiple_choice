package haui.csn.thitot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "exam_answers")
public class ExamAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_detail_id")
    private Integer examDetailId;

    @ManyToOne
    @JoinColumn(name = "result_id", nullable = false)
    private Result result;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    // ✅ Lưu lựa chọn người dùng (A/B/C/D)
    @Column(name = "selected_answer_id", length = 5)
    private Integer selectedAnswerId;

    // ✅ Lưu đáp án đúng (A/B/C/D)
    @Column(name = "is_correct", length = 5)
    private String isCorrect;

    @Column(name = "answered_at")
    private LocalDateTime answeredAt;


}
