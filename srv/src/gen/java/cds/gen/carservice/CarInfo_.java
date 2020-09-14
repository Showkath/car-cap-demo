package cds.gen.carservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import com.sap.cds.ql.cqn.CqnPredicate;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Function;

@CdsName("CarService.CarInfo")
public interface CarInfo_ extends StructuredType<CarInfo_> {
  String CDS_NAME = "CarService.CarInfo";

  ElementRef<String> descr();

  ElementRef<String> carBrandInfoId();

  ElementRef<String> carBrand_ID();

  CarBrandInfo_ carBrand();

  CarBrandInfo_ carBrand(Function<CarBrandInfo_, CqnPredicate> filter);

  ElementRef<Boolean> discount();

  ElementRef<String> ID();

  CarFavourites_ favouriteCars();

  CarFavourites_ favouriteCars(Function<CarFavourites_, CqnPredicate> filter);

  ElementRef<Integer> stock();
}
