package cds.gen.carservice;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;

@CdsName("CarService.CarInfo")
public interface CarInfo extends CdsData {
  String DESCR = "descr";

  String CAR_BRAND_INFO_ID = "carBrandInfoId";

  String CAR_BRAND_ID = "carBrand_ID";

  String CAR_BRAND = "carBrand";

  String DISCOUNT = "discount";

  String ID = "ID";

  String FAVOURITE_CARS = "favouriteCars";

  String STOCK = "stock";

  String getDescr();

  void setDescr(String descr);

  String getCarBrandInfoId();

  void setCarBrandInfoId(String carBrandInfoId);

  @CdsName(CAR_BRAND_ID)
  String getCarBrandId();

  @CdsName(CAR_BRAND_ID)
  void setCarBrandId(String carBrandId);

  CarBrandInfo getCarBrand();

  void setCarBrand(Map<String, ?> carBrand);

  Boolean getDiscount();

  void setDiscount(Boolean discount);

  @CdsName(ID)
  String getId();

  @CdsName(ID)
  void setId(String id);

  List<CarFavourites> getFavouriteCars();

  void setFavouriteCars(List<? extends Map<String, ?>> favouriteCars);

  Integer getStock();

  void setStock(Integer stock);

  static CarInfo create() {
    return Struct.create(CarInfo.class);
  }
}
