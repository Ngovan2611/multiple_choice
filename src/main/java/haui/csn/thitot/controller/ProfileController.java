package haui.csn.thitot.controller;


import haui.csn.thitot.entity.User;
import haui.csn.thitot.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/profile/update")
    public String update(
            @RequestParam String fullName,
            @RequestParam String username,
            @RequestParam String className,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam(required = false) String password,
            HttpSession session,
            Model model) {

        User user = (User) session.getAttribute("user"); // ✅ Lấy trực tiếp từ session
        if (user == null) {
            return "redirect:/login";
        }

        user.setFull_name(fullName);
        user.setPhone(phone);
        user.setUsername(username);
        user.setClassName(className);
        user.setEmail(email);
        if (password != null && !password.isBlank()) {
            user.setPassword(password);
        }

        userService.save(user);
        session.setAttribute("user", user); // ✅ Cập nhật lại session

        // 🔹 Thêm dòng này để tránh lỗi Thymeleaf
        model.addAttribute("user", user);

        model.addAttribute("success", "Cập nhật thông tin thành công!");

        return "profile"; // ✅ Giờ Thymeleaf có thể đọc được ${user.xxx}
    }


}
