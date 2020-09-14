package cds.gen.com.sap.it.capire.car.model;

import com.sap.cds.ql.CdsName;
import java.lang.Class;
import java.lang.String;

@CdsName("com.sap.it.capire.car.model")
public interface Model_ {
  String CDS_NAME = "com.sap.it.capire.car.model";

  Class<CarFavourites_> CAR_FAVOURITES = CarFavourites_.class;

  Class<CarBrandInfo_> CAR_BRAND_INFO = CarBrandInfo_.class;

  Class<CarInfo_> CAR_INFO = CarInfo_.class;
}
