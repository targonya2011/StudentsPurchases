import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Subscriptions")
@Table(name = "subscriptions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscriptions {

    @EmbeddedId
    private SubscriptionsId id;


    @Column(name = "subscription_date")
    private LocalDateTime subscriptionDate;



}
