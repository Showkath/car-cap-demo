package cds.gen.carservice;

import com.sap.cds.ql.CdsName;
import java.lang.Class;
import java.lang.String;

@CdsName("CarService")
public interface CarService_ {
  String CDS_NAME = "CarService";

  Class<CarBrandInfo_> CAR_BRAND_INFO = CarBrandInfo_.class;

  Class<CarInfo_> CAR_INFO = CarInfo_.class;

  Class<CarFavourites_> CAR_FAVOURITES = CarFavourites_.class;
}
