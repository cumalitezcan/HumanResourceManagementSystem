package kodlamaio.HRMS.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="verification_by_codes")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id")

public class VerificationByCode extends Verification {

    @Column(name = "user_id")
    private int userId;

    @Column(name = "code")
    private String code;

}
