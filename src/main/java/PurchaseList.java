import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "PurchaseList")
@Table(name = "purchaseList")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseList {

    @EmbeddedId
    private PurchaseListId id;

    private int price;
    @Column(name = "subscription_date")
    private LocalDateTime subscriptionDate;



}
