package cds.gen.com.sap.it.capire.car.model;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.String;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@CdsName("com.sap.it.capire.car.model.CarBrandInfo")
public interface CarBrandInfo extends CdsData {
  String CREATED_AT = "createdAt";

  String DESCR = "descr";

  String CARS = "cars";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String MODIFIED_BY = "modifiedBy";

  String ID = "ID";

  String CAR_BRAND_FAV = "carBrandFav";

  Instant getCreatedAt();

  void setCreatedAt(Instant createdAt);

  String getDescr();

  void setDescr(String descr);

  List<CarInfo> getCars();

  void setCars(List<? extends Map<String, ?>> cars);

  String getCreatedBy();

  void setCreatedBy(String createdBy);

  Instant getModifiedAt();

  void setModifiedAt(Instant modifiedAt);

  String getModifiedBy();

  void setModifiedBy(String modifiedBy);

  @CdsName(ID)
  String getId();

  @CdsName(ID)
  void setId(String id);

  List<CarFavourites> getCarBrandFav();

  void setCarBrandFav(List<? extends Map<String, ?>> carBrandFav);

  static CarBrandInfo create() {
    return Struct.create(CarBrandInfo.class);
  }
}
