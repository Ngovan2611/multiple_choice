package haui.csn.thitot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    private String full_name;
    private String username;
    @Column(name = "class_name")
    private String className;
    private String password;
    private String email;
    private String phone;
    private String role;
    private String created_at;


}
