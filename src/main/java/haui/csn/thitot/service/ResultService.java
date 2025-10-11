package haui.csn.thitot.service;

import haui.csn.thitot.entity.Question;
import haui.csn.thitot.entity.Result;
import haui.csn.thitot.entity.User;
import haui.csn.thitot.repository.AnswerRepository;
import haui.csn.thitot.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ResultService {
    @Autowired private QuestionService questionService;
    @Autowired private AnswerRepository answerRepository;
    @Autowired private ExamService examService;
    @Autowired private ResultRepository resultRepository;

    public Result gradeExamAndSave(User user, Integer examId, Map<Integer, String> userAnswers) {
        List<Question> questions = questionService.getAllQuestionsByExam_Id(examId);
        int correct = 0, incorrect = 0;

        for (Question q : questions) {
            String userChoice = userAnswers.get(q.getQuestionId());
            if (userChoice == null) continue;

            String correctAnswer = answerRepository.findCorrectAnswerByQuestionId(q.getQuestionId());
            if (userChoice.equalsIgnoreCase(correctAnswer)) correct++;
            else incorrect++;
        }

        double score = (double) correct / questions.size() * 10.0;

        Result result = new Result();
        result.setUser(user);
        result.setExam(examService.getExamById(examId));
        result.setScore(score);
        result.setCorrectCount(correct);
        result.setIncorrectCount(incorrect);
        result.setStartTime(LocalDateTime.now().minusMinutes(45));
        result.setEndTime(LocalDateTime.now());
        result.setStatus(Result.Status.completed);

        return resultRepository.save(result);
    }
    public List<Result> getResultsByUser(User user) {
        return resultRepository.findByUser(user);
    }
}
