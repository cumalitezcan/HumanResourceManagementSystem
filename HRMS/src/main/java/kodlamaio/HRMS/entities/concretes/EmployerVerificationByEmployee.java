package kodlamaio.HRMS.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="employee_confirm_employers")
@AllArgsConstructor
@NoArgsConstructor
public class EmployerVerificationByEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="employer_id")
    private int employerId;

    @Column(name="employee_id")
    private int employeeId;

    @Column(name="is_confirmed",columnDefinition="boolean default false")
    private int isConfirmed;


}
