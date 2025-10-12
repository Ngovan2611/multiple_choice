package haui.csn.thitot.service;

import haui.csn.thitot.entity.ExamAnswer;
import haui.csn.thitot.repository.ExamAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExamAnswerService {

    @Autowired
    private ExamAnswerRepository examAnswerRepository;

    public List<ExamAnswer> getExamAnswerDetails(Integer resultId) {
        return examAnswerRepository.findByResultId(resultId);
    }

    public ExamAnswer save(ExamAnswer examAnswer) {
        return examAnswerRepository.save(examAnswer);
    }

    // Lưu danh sách câu trả lời (khi nộp bài)
    public void saveAll(List<ExamAnswer> examAnswers) {
        examAnswerRepository.saveAll(examAnswers);
    }
}
