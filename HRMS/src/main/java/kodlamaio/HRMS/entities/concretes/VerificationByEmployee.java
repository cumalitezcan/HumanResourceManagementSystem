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
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="verification_by_employees")
@PrimaryKeyJoinColumn(name = "id")

public class VerificationByEmployee extends Verification {

    @Column(name = "employer_id")
    private int employerId;

    @Column(name = "employee_id")
    private Integer employeeId;
}
