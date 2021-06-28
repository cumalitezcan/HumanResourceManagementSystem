package kodlamaio.HRMS.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="images")
@Inheritance(strategy = InheritanceType.JOINED)
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="url")
    private String url;

    @Column(name = "created_date")
    private LocalDate createdDate;

   /* @OneToOne
    @JoinColumn(name = "id")
    private User user;*/

}
