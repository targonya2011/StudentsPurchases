import jakarta.persistence.*;
import lombok.*;


@Entity(name = "Courses")
@Table(name = "courses")
@NoArgsConstructor
@Data
public class Courses {
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

    private int duration;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private CourseType type;

    @Column(nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(
            name = "teacher_id",
            foreignKey = @ForeignKey(name = "teacher_fk")
    )
    private Teachers teachers;

    @Column(name = "students_count")
    private Integer studentsCount;
    private int price;
    @Column(name = "price_per_hour")
    private float pricePerHour;

}
