import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Students")
@Table(name = "students")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Students {
    @Id
    @Column(
            name = "id",
            updatable = false
    )
    private int id;
    @Column(name = "name",
            updatable = false,
            insertable = false
    )
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "registration_date")
    private Date registrationDate;

}
