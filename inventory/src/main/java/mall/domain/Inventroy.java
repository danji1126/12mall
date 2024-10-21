package mall.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import mall.InventoryApplication;
import mall.domain.InventoryIncreased;
import mall.domain.InventroyDecreased;

@Entity
@Table(name = "Inventroy_table")
@Data
//<<< DDD / Aggregate Root
public class Inventroy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist() {
        InventroyDecreased inventroyDecreased = new InventroyDecreased(this);
        inventroyDecreased.publishAfterCommit();

        InventoryIncreased inventoryIncreased = new InventoryIncreased(this);
        inventoryIncreased.publishAfterCommit();
    }

    public static InventroyRepository repository() {
        InventroyRepository inventroyRepository = InventoryApplication.applicationContext.getBean(
            InventroyRepository.class
        );
        return inventroyRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreaseInventory(DeliveryStarted deliveryStarted) {
        //implement business logic here:

        /** Example 1:  new item 
        Inventroy inventroy = new Inventroy();
        repository().save(inventroy);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(inventroy->{
            
            inventroy // do something
            repository().save(inventroy);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseInventory(DeliveryCancelled deliveryCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        Inventroy inventroy = new Inventroy();
        repository().save(inventroy);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCancelled.get???()).ifPresent(inventroy->{
            
            inventroy // do something
            repository().save(inventroy);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
