import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseListId implements Serializable {

    @Column(
            name = "student_name"
    )
    private String studentName;
    @Column(
            name = "course_name"
    )
    private String courseName;

}
