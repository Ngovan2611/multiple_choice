package haui.csn.thitot.controller;


import haui.csn.thitot.entity.User;
import haui.csn.thitot.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

@Controller
public class LoginController {
    @Autowired
    private View error;

    @GetMapping("/login")
    public String home() {
        return "login";
    }

    @Autowired
    UserRepository userRepository;
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password
    ,Model model, HttpSession session) {
        User user = userRepository.findUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "redirect:/home";
        }
        else {
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu!");
            return "login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }
}


