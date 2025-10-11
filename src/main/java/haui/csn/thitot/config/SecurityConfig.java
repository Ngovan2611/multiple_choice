package haui.csn.thitot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Cho phép tất cả request mà không cần xác thực
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )
                // Tắt CSRF (tránh lỗi 403 khi dùng form)
                .csrf(csrf -> csrf.disable())
                // Tắt luôn frameOptions (nếu dùng H2 console hoặc iframe)
                .headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }
}
