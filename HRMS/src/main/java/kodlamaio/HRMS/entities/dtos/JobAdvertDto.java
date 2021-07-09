package kodlamaio.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {
    private int jobPositionId;
    private int employerId;
    private int cityId;
    private int workPlaceId;
    private int workTimeId;
    private int salaryMax;
    private int salaryMin;
    private int openPositionCount;
    private String description;
    private LocalDate applicationDeadline;
    private boolean isOpen;
}
