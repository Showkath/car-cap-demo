package cds.gen.carservice;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;

@CdsName("CarService.CarFavourites")
public interface CarFavourites extends CdsData {
  String FAVOURITE_CAR_BRAND = "favouriteCarBrand";

  String FAV_CAR = "favCar";

  String FAVOURITE_CAR_ID = "favouriteCar_ID";

  String FAVOURITE_CAR_BRAND_ID = "favouriteCarBrand_ID";

  String IS_LIKED = "isLiked";

  String FAV_BRAND = "favBrand";

  String FAVKEY_ID = "favkeyId";

  String USER_ID = "userId";

  String FAVOURITE_CAR = "favouriteCar";

  CarBrandInfo getFavouriteCarBrand();

  void setFavouriteCarBrand(Map<String, ?> favouriteCarBrand);

  String getFavCar();

  void setFavCar(String favCar);

  @CdsName(FAVOURITE_CAR_ID)
  String getFavouriteCarId();

  @CdsName(FAVOURITE_CAR_ID)
  void setFavouriteCarId(String favouriteCarId);

  @CdsName(FAVOURITE_CAR_BRAND_ID)
  String getFavouriteCarBrandId();

  @CdsName(FAVOURITE_CAR_BRAND_ID)
  void setFavouriteCarBrandId(String favouriteCarBrandId);

  Boolean getIsLiked();

  void setIsLiked(Boolean isLiked);

  String getFavBrand();

  void setFavBrand(String favBrand);

  Integer getFavkeyId();

  void setFavkeyId(Integer favkeyId);

  String getUserId();

  void setUserId(String userId);

  CarInfo getFavouriteCar();

  void setFavouriteCar(Map<String, ?> favouriteCar);

  static CarFavourites create() {
    return Struct.create(CarFavourites.class);
  }
}
