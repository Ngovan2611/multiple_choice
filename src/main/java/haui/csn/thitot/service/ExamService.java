package haui.csn.thitot.service;


import haui.csn.thitot.entity.Exam;
import haui.csn.thitot.entity.Subject;
import haui.csn.thitot.entity.User;
import haui.csn.thitot.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;
    public List<Exam> getExamBySubjectAndTotalQuestions(Subject subject, Integer totalQuestions) {
        return examRepository.findBySubjectAndTotalQuestions(subject, totalQuestions);
    }

    public List<Exam> getExamByCreateBy() {
        return examRepository.findAllByTeacherRole();
    }
    public Exam getExamById(Integer id) {
        return examRepository.findById(id).get();
    }
}
