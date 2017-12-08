package pl.com.bottega.factory.delivery.planning.projection;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import pl.com.bottega.tools.ProjectionDao;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Repository
@RepositoryRestResource(
        path = "delivery/planning/forecasts",
        collectionResourceRel = "forecast of deliveries")
public interface DeliveryForecastDao extends ProjectionDao<DeliveryForecastEntity, Long> {

    List<DeliveryForecastEntity> findByRefNoAndDateGreaterThanEqual(String refNo, Instant instant);

    @RestResource(exported = false)
    void deleteByRefNoAndDate(String refNo, LocalDate date);

    @RestResource(exported = false)
    void deleteByRefNo(String refNo);
}