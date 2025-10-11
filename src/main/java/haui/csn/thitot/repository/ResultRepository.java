package haui.csn.thitot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import haui.csn.thitot.entity.Result;
import haui.csn.thitot.entity.User;
import haui.csn.thitot.entity.Exam;


import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Integer> {

    /**
     * 🔍 Lấy danh sách kết quả theo người dùng
     */
    @Query("SELECT r FROM Result r WHERE r.user.id = :userId ORDER BY r.endTime DESC")
    List<Result> findByUserId(@Param("userId") Integer userId);

    /**
     * 🔍 Kiểm tra xem người dùng đã thi bài này chưa
     */
    @Query("SELECT r FROM Result r WHERE r.user = :user AND r.exam = :exam")
    Result findByUserAndExam(@Param("user") User user, @Param("exam") Exam exam);

    /**
     * 🔍 Lấy danh sách kết quả theo mã đề thi
     */
    @Query("SELECT r FROM Result r WHERE r.exam.examId = :examId")
    List<Result> findByExamId(@Param("examId") Integer examId);
    List<Result> findByUser(User user);

}

