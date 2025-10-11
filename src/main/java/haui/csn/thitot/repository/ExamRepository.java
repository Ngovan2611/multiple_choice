package haui.csn.thitot.repository;

import haui.csn.thitot.entity.Exam;
import haui.csn.thitot.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {
    Exam findById(int id);

    List<Exam> findBySubjectAndTotalQuestions(Subject subject, Integer totalQuestions);

    @Query("SELECT e FROM Exam e WHERE e.createdBy.role = 'teacher'")
    List<Exam> findAllByTeacherRole();

}
