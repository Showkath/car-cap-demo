package cds.gen.carservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import com.sap.cds.ql.cqn.CqnPredicate;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Function;

@CdsName("CarService.CarFavourites")
public interface CarFavourites_ extends StructuredType<CarFavourites_> {
  String CDS_NAME = "CarService.CarFavourites";

  CarBrandInfo_ favouriteCarBrand();

  CarBrandInfo_ favouriteCarBrand(Function<CarBrandInfo_, CqnPredicate> filter);

  ElementRef<String> favCar();

  ElementRef<String> favouriteCar_ID();

  ElementRef<String> favouriteCarBrand_ID();

  ElementRef<Boolean> isLiked();

  ElementRef<String> favBrand();

  ElementRef<Integer> favkeyId();

  ElementRef<String> userId();

  CarInfo_ favouriteCar();

  CarInfo_ favouriteCar(Function<CarInfo_, CqnPredicate> filter);
}
