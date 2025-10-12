package haui.csn.thitot.repository;

import haui.csn.thitot.entity.Result;
import haui.csn.thitot.entity.User;
import haui.csn.thitot.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {

    /**
      Lấy danh sách kết quả theo người dùng*/
    @Query("SELECT r FROM Result r WHERE r.user.id = :userId ORDER BY r.endTime DESC")
    List<Result> findByUserId(@Param("userId") Integer userId);

    /**
     * Kiểm tra xem người dùng đã thi bài này chưa
     */
    @Query("SELECT r FROM Result r WHERE r.user = :user AND r.exam = :exam")
    Result findByUserAndExam(@Param("user") User user, @Param("exam") Exam exam);

    /**
     * Lấy danh sách kết quả theo mã đề thi
     */
    @Query("SELECT r FROM Result r WHERE r.exam.examId = :examId")
    List<Result> findByExamId(@Param("examId") Integer examId);

    /**
     * Lấy tất cả kết quả theo user (dùng cho trang lịch sử)
     */
    List<Result> findByUser(User user);

    /**
     * Lấy chi tiết kết quả theo ID
     */
    @Query("SELECT r FROM Result r WHERE r.resultId = :id")
    Result findByResultId(@Param("id") Integer id);

    /**
     * Tự động fetch danh sách câu trả lời khi lấy Result (nếu có quan hệ mappedBy)
     */
    @Query("""
        SELECT DISTINCT r FROM Result r
        LEFT JOIN FETCH r.examAnswers ea
        LEFT JOIN FETCH ea.question q
        WHERE r.resultId = :resultId
    """)
    Result findWithAnswersById(@Param("resultId") Integer resultId);
}
