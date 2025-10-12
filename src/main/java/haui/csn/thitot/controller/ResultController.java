package haui.csn.thitot.controller;


import haui.csn.thitot.entity.User;
import haui.csn.thitot.service.ResultService;
import haui.csn.thitot.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import haui.csn.thitot.entity.Exam;
import haui.csn.thitot.entity.Result;
import haui.csn.thitot.entity.User;
import haui.csn.thitot.service.ExamService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ResultController {


    @Autowired private ResultService resultService;

    @GetMapping("/history")
    public String history(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user == null) {
            return "redirect:/login";
        }
        List<Result> results = resultService.getResultsByUser(user);
        model.addAttribute("user", user);
        model.addAttribute("results", results);
        return "history";
    }


    @PostMapping("/exam/{examId}/submit")
    public String submitExam(@PathVariable Integer examId,
                             @RequestParam Map<String, String> allParams,
                             HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";

        Map<Integer, String> userAnswers = new HashMap<>();
        for (Map.Entry<String, String> entry : allParams.entrySet()) {
            if (entry.getKey().startsWith("answers_")) {
                Integer qId = Integer.valueOf(entry.getKey().replaceAll("[^0-9]", ""));
                userAnswers.put(qId, entry.getValue()); // Lưu A/B/C/D
            }
        }

        Result result = resultService.gradeExamAndSave(user, examId, userAnswers);

        return "index";
    }


}
