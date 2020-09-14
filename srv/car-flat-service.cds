using com.sap.it.capire.car.model as carModel from '../db/flat-data-model';

//service CarAdminService @(_requires : 'admin') {
service CarFlatService {

    

    /* Assignment 1 start */
    /*
     //Full join wont wont work in SQLite but works in HANA SQL
      view carBrandFavouritesViewFull as
        select from carModel.CarBrandFavouritesFlat as carBrandFavourites
        full join carModel.CarBrandInfoFlat as carBrandInfo
            on carBrandFavourites.ID = carBrandInfo.ID
        {
           key carBrandFavourites.ID,
                isLiked,
                description
        };

    view carFavouritesViewFull as
        select from carModel.CarInfoFavouritesFlat as carFavourites
        full join carModel.CarInfoFlat as carInfo
            on carFavourites.ID = carInfo.ID
        {
           key carFavourites.ID,
                isLiked,
                description
        };
        
        */
    //Caused by: org.sqlite.SQLiteException: [SQLITE_ERROR] SQL error or missing database (RIGHT and FULL OUTER JOINs are not currently supported)
    
    //Workaround for SQLite
    view CarBrand as
            select from carModel.CarBrandFavouritesFlat as carBrandFavourites
            left join carModel.CarBrandInfoFlat as carBrandInfo
                on carBrandFavourites.ID = carBrandInfo.ID
            {
                key carBrandFavourites.ID as ID,
                isLiked,
                description
            }
        union
            select from carModel.CarBrandInfoFlat as carBrandInfo {
                key  ID as ID,
                    '' as isLiked,
                    '' as description                    
            }//to avoid redundancy/duplicates             
            where
                not exists(select carBrandFavourites.ID from carModel.CarBrandFavouritesFlat as carBrandFavourites
                where
                    carBrandFavourites.ID = carBrandInfo.ID
                );
//group by carInfo.ID; // may be needed to prevent duplicate records from second select statement

view Car as
            select from carModel.CarInfoFavouritesFlat as carFavourites
            left join carModel.CarInfoFlat as carInfo
                on carFavourites.ID = carInfo.ID
            {
                key carFavourites.ID as ID,
                isLiked,
                description
            }
        union
            select from carModel.CarInfoFlat as carInfo {
                key  ID as ID,
                    '' as isLiked,
                    '' as description                    
            }//to avoid redundancy/duplicates             
            where
                not exists(select carFavourites.ID from carModel.CarInfoFavouritesFlat as carFavourites
                where
                    carFavourites.ID = carInfo.ID
                );
//group by carInfo.ID; // may be needed to prevent duplicate records from second select statement


 /* Assignment 1 completed  */
 //Aggregation of both views is Optimal  way to write  full join of two views CarBrand and Car
 //Alternative is Union
 /*
 view CarAndCarBrandFavouritesViewFlat as
        select from Car  as carFavourites
            left join CarBrand as carBrandFavourites 
                on carFavourites.ID = carBrandFavourites.ID //car.BrandId=brandId, Incorrect condition never true :)
            {
                key carFavourites.ID as ID,
                carFavourites.isLiked as Liked,
                carFavourites.description as description
            }
        //expecting ';', EXCEPT, EXCLUDING, GROUP, HAVING, INTERSECT, LIMIT, MINUS, ORDER, UNION, WHERE
        union
            select from CarBrand as carBrandFavourites {
                key  ID as ID,
                    '' as isLiked,
                    '' as description                    
            }
            */
            //to avoid redundancy/duplicates 
            /*            
            where
                not exists(select carBrandFavourites.ID from carModel.CarInfoFavouritesFlat as carFavourites
                where
                    carFavourites.ID = carInfo.ID
                );
                */

 /* Below is not related to Assignment 1,just left join  */
view selectedCarFavouritesViewFlat as
        select from carModel.CarInfoFavouritesFlat as carFavourites
        left join carModel.CarInfoFlat as carInfo
            on carFavourites.ID = carInfo.ID
        {
            key carFavourites.ID,
                isLiked,
                description
        };


}
