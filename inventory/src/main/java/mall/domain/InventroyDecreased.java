package mall.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mall.domain.*;
import mall.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InventroyDecreased extends AbstractEvent {

    private Long id;

    public InventroyDecreased(Inventroy aggregate) {
        super(aggregate);
    }

    public InventroyDecreased() {
        super();
    }
}
//>>> DDD / Domain Event
