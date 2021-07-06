package kodlamaio.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private int id;
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private String  url;
}
