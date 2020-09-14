package cds.gen.com.sap.it.capire.car.model;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import com.sap.cds.ql.cqn.CqnPredicate;
import java.lang.String;
import java.time.Instant;
import java.util.function.Function;

@CdsName("com.sap.it.capire.car.model.CarBrandInfo")
public interface CarBrandInfo_ extends StructuredType<CarBrandInfo_> {
  String CDS_NAME = "com.sap.it.capire.car.model.CarBrandInfo";

  ElementRef<Instant> createdAt();

  ElementRef<String> descr();

  CarInfo_ cars();

  CarInfo_ cars(Function<CarInfo_, CqnPredicate> filter);

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  ElementRef<String> modifiedBy();

  ElementRef<String> ID();

  CarFavourites_ carBrandFav();

  CarFavourites_ carBrandFav(Function<CarFavourites_, CqnPredicate> filter);
}
