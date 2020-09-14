
CREATE TABLE com_sap_it_capire_car_model_CarBrandInfo (
  createdAt TIMESTAMP,
  createdBy NVARCHAR(255),
  modifiedAt TIMESTAMP,
  modifiedBy NVARCHAR(255),
  ID NVARCHAR(1111) NOT NULL,
  descr NVARCHAR(1111),
  PRIMARY KEY(ID)
);

CREATE TABLE com_sap_it_capire_car_model_CarFavourites (
  favkeyId INTEGER NOT NULL,
  userId NVARCHAR(1111),
  isLiked BOOLEAN,
  favouriteCarBrand_ID NVARCHAR(1111),
  favouriteCar_ID NVARCHAR(1111),
  PRIMARY KEY(favkeyId)
);

CREATE TABLE com_sap_it_capire_car_model_CarInfo (
  createdAt TIMESTAMP,
  createdBy NVARCHAR(255),
  modifiedAt TIMESTAMP,
  modifiedBy NVARCHAR(255),
  ID NVARCHAR(1111) NOT NULL,
  descr NVARCHAR(1111),
  stock INTEGER,
  discount BOOLEAN DEFAULT FALSE,
  carBrand_ID NVARCHAR(1111),
  PRIMARY KEY(ID)
);

CREATE VIEW CarService_CarBrandInfo AS SELECT
  CarBrandInfo_0.createdAt,
  CarBrandInfo_0.createdBy,
  CarBrandInfo_0.modifiedAt,
  CarBrandInfo_0.modifiedBy,
  CarBrandInfo_0.ID,
  CarBrandInfo_0.descr
FROM com_sap_it_capire_car_model_CarBrandInfo AS CarBrandInfo_0;

CREATE VIEW CarService_CarFavourites AS SELECT
  CarFavourites_0.favkeyId,
  CarFavourites_0.userId,
  CarFavourites_0.isLiked,
  favouriteCarBrand_1.ID AS favBrand,
  favouriteCar_2.ID AS favCar,
  CarFavourites_0.favouriteCarBrand_ID,
  CarFavourites_0.favouriteCar_ID
FROM ((com_sap_it_capire_car_model_CarFavourites AS CarFavourites_0 LEFT JOIN com_sap_it_capire_car_model_CarBrandInfo AS favouriteCarBrand_1 ON (CarFavourites_0.favouriteCarBrand_ID = favouriteCarBrand_1.ID)) LEFT JOIN com_sap_it_capire_car_model_CarInfo AS favouriteCar_2 ON (CarFavourites_0.favouriteCar_ID = favouriteCar_2.ID))
ORDER BY CarFavourites_0.isLiked ASC;

CREATE VIEW CarService_CarInfo AS SELECT
  CarInfo_0.ID,
  CarInfo_0.descr,
  CarInfo_0.stock,
  CarInfo_0.discount,
  carBrand_1.ID AS carBrandInfoId,
  CarInfo_0.carBrand_ID
FROM (com_sap_it_capire_car_model_CarInfo AS CarInfo_0 LEFT JOIN com_sap_it_capire_car_model_CarBrandInfo AS carBrand_1 ON (CarInfo_0.carBrand_ID = carBrand_1.ID));

