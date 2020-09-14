package com.sap.it.cap.car.handlers;

import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.sap.cds.services.cds.CdsService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.After;
import com.sap.cds.services.handler.annotations.ServiceName;

import cds.gen.carservice.CarService_;
import cds.gen.carservice.CarBrandInfo;
import cds.gen.carservice.CarBrandInfo_;
import cds.gen.carservice.CarFavourites_;
import cds.gen.carservice.CarInfo;
import java.util.HashMap;
import java.util.Map;
import com.sap.cds.services.handler.annotations.On;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sap.cds.services.EventContext;
import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.handler.annotations.Before;

@Component
@ServiceName(CarService_.CDS_NAME)
/*
 * @author = I311690
 * 
 * @since = 24/06/2020
 * 
 * @language=CAP ,Java; multiTenant=No
 * 
 * @description:Request interceptor Handlers/Extensions,Validations The event
 * handler documentaions :https://cap.cloud.sap/docs/java/provisioning-api Event
 * handler methods are registered with @On, @Before, or @After annotation CDS
 * Query Notation (CQN) is the common language in CAP to run queries against
 * services. It can be used to talk to the services defined by your model, but
 * also remote services, such as the database Syntax for joins,
 * https://cap.cloud.sap/docs/cds/cqn :
 * 
 */
public class CarServiceHandler implements EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceHandler.class);
    // Best practices dont hardcore cds artifact names
    private static final String CAR_INFO_ENTITY = cds.gen.carservice.CarInfo_.CDS_NAME;
    private static final String CARBRAND_INFO_ENTITY = cds.gen.carservice.CarBrandInfo_.CDS_NAME;
    private static final String CARFAVOURITES_ENTITY = cds.gen.carservice.CarFavourites_.CDS_NAME;

    private Map<Object, Map<String, Object>> carfavourites = new HashMap<>();// favourites kept in memory

    @After(event = CdsService.EVENT_READ)
    public void discountCars(Stream<CarInfo> carInfo) {
        carInfo.filter(item -> item.getStock() != null).filter(item -> item.getStock() >= 500)
                // .forEach(item -> item.setDescr(item.getDescr() + " ( * discounted)"));  
                .forEach(item -> {
                    item.setDescr(item.getDescr() + " ( * discounted)");
                    item.setDiscount(true);
                });
    }

    @On(event = CdsService.EVENT_READ, entity = CARFAVOURITES_ENTITY)
    public void onRead(CdsReadEventContext context) {
        LOGGER.info("On Read extension was called for CARFAVOURITES_ENTITY. ");
        // car favourites kept in memory
        context.setResult(carfavourites.values());
    }

    @Before(event = CdsService.EVENT_READ, entity = CARFAVOURITES_ENTITY)
    public void beforeReadForExchangeRateType(CdsReadEventContext cdsReadEventContext) {
        LOGGER.info("Before Read event extension for CARFAVOURITES_ENTITY was called.");
        // CdsDataStore TODO
    }

    @On(event = CdsService.EVENT_CREATE, entity = CARFAVOURITES_ENTITY)
    public void onCreate(CdsCreateEventContext context) {

        LOGGER.info("On Create extension was called for CARFAVOURITES_ENTITY. ");
        context.getCqn().entries().forEach(e -> carfavourites.put(e.get("favkeyId"), e));
        context.setResult(context.getCqn().entries());
    }

}