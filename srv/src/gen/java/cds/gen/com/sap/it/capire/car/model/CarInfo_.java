package cds.gen.com.sap.it.capire.car.model;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import com.sap.cds.ql.cqn.CqnPredicate;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.time.Instant;
import java.util.function.Function;

@CdsName("com.sap.it.capire.car.model.CarInfo")
public interface CarInfo_ extends StructuredType<CarInfo_> {
  String CDS_NAME = "com.sap.it.capire.car.model.CarInfo";

  ElementRef<Instant> createdAt();

  ElementRef<String> descr();

  ElementRef<String> carBrand_ID();

  CarBrandInfo_ carBrand();

  CarBrandInfo_ carBrand(Function<CarBrandInfo_, CqnPredicate> filter);

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  ElementRef<Boolean> discount();

  ElementRef<String> modifiedBy();

  ElementRef<String> ID();

  CarFavourites_ favouriteCars();

  CarFavourites_ favouriteCars(Function<CarFavourites_, CqnPredicate> filter);

  ElementRef<Integer> stock();
}
