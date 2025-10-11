package haui.csn.thitot.repository;


import haui.csn.thitot.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByExam_ExamId(Integer examId);

}
