import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionsId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "student_id",
            foreignKey = @ForeignKey(name = "student_id_fk")
    )
    private Students students;

    @ManyToOne
    @JoinColumn(name = "course_id",
            foreignKey = @ForeignKey(name = "course_id_fk")
    )
    private Courses courses;


}
