import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Teachers")
@Table(name = "teachers")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Teachers {
    @Id
    @Column(
            name = "id",
            updatable = false
    )
    private int id;
    private String name;
    private int salary;
    private int age;

}
