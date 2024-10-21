package mall.domain;

import mall.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "inventroys",
    path = "inventroys"
)
public interface InventroyRepository
    extends PagingAndSortingRepository<Inventroy, Long> {}
