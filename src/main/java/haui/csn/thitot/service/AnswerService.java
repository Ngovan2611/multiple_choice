package haui.csn.thitot.service;


import haui.csn.thitot.entity.Answer;
import haui.csn.thitot.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    // Lấy đáp án theo questionId
    public Answer getAnswerByQuestionId(Integer questionId) {
        return answerRepository.findByQuestionId(questionId).orElse(null);
    }

    // Lấy ký tự đáp án đúng (A/B/C/D)
    public String getCorrectAnswer(Integer questionId) {
        return answerRepository.findCorrectAnswerByQuestionId(questionId);
    }

    // Kiểm tra xem người dùng chọn đúng hay sai
    public boolean checkAnswer(Integer questionId, String userChoice) {
        String correct = getCorrectAnswer(questionId);
        return correct != null && userChoice != null && correct.equalsIgnoreCase(userChoice);
    }
}

