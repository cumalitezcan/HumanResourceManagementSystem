package kodlamaio.HRMS.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name="verification_codes")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="code")
    private String verificationCode;

    @Column(name="is_verified",columnDefinition = "boolean default false")
    private boolean isVerified;

    @Column(name="verified_date")
    private LocalDate verifiedDate = LocalDate.now();


}
