using com.sap.it.capire.car.model as carModel from '../db/data-model';
//@purpose: Assignment Joins, Fulljoin, Views on Car CAP Sample Services data model
//author: I311690
//@since: 27/07/2020
//service CarAdminService @(_requires : 'admin') {
service CarService {

    entity CarBrandInfo  as projection on carModel.CarBrandInfo;

    //@readonly  entity CarInfo    as projection on carModel.CarInfo;
    @readonly
    entity CarInfo       as
        select from carModel.CarInfo {
            *,
            carBrand.ID as carBrandInfoId
        }
        excluding {
            createdBy,
            modifiedBy,
            createdAt,
            modifiedAt
        };


    //@requires_: 'authenticated-user'
    //entity CarFavourites        as projection on carModel.CarFavourites;
    entity CarFavourites as
        select from carModel.CarFavourites {
            *,
            favouriteCarBrand.ID as favBrand,
            favouriteCar.ID      as favCar
        }
        order by
            CarFavourites.isLiked asc;
    


    view selectedCarFavouritesView as
        select from carModel.CarFavourites as carFavourites
        left join carModel.CarInfo as carInfo
            on carFavourites.favouriteCar.ID = carInfo.ID
        {
            key favkeyId,
                isLiked,
                userId,
                favouriteCarBrand.ID as brand,
                favouriteCar.ID      as car
        };


    /*
    view carFavouritesViewFull as
        select from carModel.CarFavourites as carFavourites
        full join carModel.CarInfo as carInfo
            on carFavourites.favouriteCar.ID = carInfo.ID
        {
            key favkeyId,
                isLiked,
                userId,
                favouriteCarBrand.ID as brand,
                favouriteCar.ID      as car
        };
        */
    //Caused by: org.sqlite.SQLiteException: [SQLITE_ERROR] SQL error or missing database (RIGHT and FULL OUTER JOINs are not currently supported)
    
    //Workaround for SQLite
    view carFavouritesViewFull as
            select from carModel.CarFavourites as carFavourites
            left join carModel.CarInfo as carInfo
                on carFavourites.favouriteCar.ID = carInfo.ID
            {
                key favkeyId,
                    isLiked,
                    userId,
                    favouriteCarBrand.ID as brand,
                    favouriteCar.ID      as car
            }
        union
            select from carModel.CarInfo as carInfo {
                key '' as favkeyId,
                    '' as isLiked,
                    '' as userId,
                    '' as brand,
                    ID as car
            }
            where
                not exists(select carFavourites.favouriteCar.ID from carModel.CarFavourites as carFavourites
                where
                    carFavourites.favouriteCar.ID = carInfo.ID
                );
//group by carInfo.ID; // may be needed to prevent duplicate records from second select statement


}
