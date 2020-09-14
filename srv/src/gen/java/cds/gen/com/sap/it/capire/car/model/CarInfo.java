package cds.gen.com.sap.it.capire.car.model;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@CdsName("com.sap.it.capire.car.model.CarInfo")
public interface CarInfo extends CdsData {
  String CREATED_AT = "createdAt";

  String DESCR = "descr";

  String CAR_BRAND_ID = "carBrand_ID";

  String CAR_BRAND = "carBrand";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String DISCOUNT = "discount";

  String MODIFIED_BY = "modifiedBy";

  String ID = "ID";

  String FAVOURITE_CARS = "favouriteCars";

  String STOCK = "stock";

  Instant getCreatedAt();

  void setCreatedAt(Instant createdAt);

  String getDescr();

  void setDescr(String descr);

  @CdsName(CAR_BRAND_ID)
  String getCarBrandId();

  @CdsName(CAR_BRAND_ID)
  void setCarBrandId(String carBrandId);

  CarBrandInfo getCarBrand();

  void setCarBrand(Map<String, ?> carBrand);

  String getCreatedBy();

  void setCreatedBy(String createdBy);

  Instant getModifiedAt();

  void setModifiedAt(Instant modifiedAt);

  Boolean getDiscount();

  void setDiscount(Boolean discount);

  String getModifiedBy();

  void setModifiedBy(String modifiedBy);

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
