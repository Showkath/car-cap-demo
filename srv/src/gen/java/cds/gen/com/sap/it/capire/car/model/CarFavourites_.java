package cds.gen.com.sap.it.capire.car.model;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import com.sap.cds.ql.cqn.CqnPredicate;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Function;

@CdsName("com.sap.it.capire.car.model.CarFavourites")
public interface CarFavourites_ extends StructuredType<CarFavourites_> {
  String CDS_NAME = "com.sap.it.capire.car.model.CarFavourites";

  CarBrandInfo_ favouriteCarBrand();

  CarBrandInfo_ favouriteCarBrand(Function<CarBrandInfo_, CqnPredicate> filter);

  ElementRef<String> favouriteCar_ID();

  ElementRef<String> favouriteCarBrand_ID();

  ElementRef<Boolean> isLiked();

  ElementRef<Integer> favkeyId();

  ElementRef<String> userId();

  CarInfo_ favouriteCar();

  CarInfo_ favouriteCar(Function<CarInfo_, CqnPredicate> filter);
}
