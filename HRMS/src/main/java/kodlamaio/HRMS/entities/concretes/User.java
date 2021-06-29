package kodlamaio.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Email(message = "Invalid email address. Please enter your email address correctly.")
    @NotBlank
    @NotNull
    @Column(name="email")
    private String email;

    @NotNull
    @NotBlank
    @Column(name="password")
    private String password;

    @JsonIgnore
    @OneToOne(mappedBy = "user", optional=false, fetch=FetchType.LAZY)
    private Image image;


}
