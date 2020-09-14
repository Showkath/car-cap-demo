namespace com.sap.it.capire.car.model;
//@purpose: Assignment Fulljoin, Views on Car CAP Sample Services data model
//author: I311690
//@since: 27/07/2020
using {
    Currency,
    managed
} from '@sap/cds/common';
entity CarBrandInfo : managed {
    key ID    : String(1111);
        descr : String(1111);
        cars  : Association to many CarInfo                   
                    on cars.carBrand = $self;
       carBrandFav  : Association to many CarFavourites                    
                    on carBrandFav.favouriteCarBrand = $self;

}

entity CarInfo : managed {
    key ID     : String(1111);
        descr  : String(1111);   //localized    String(1111)
        stock  : Integer;
        discount:Boolean default false; 
        carBrand  : Association to CarBrandInfo;        
        favouriteCars  : Association to many CarFavourites                    
                    on favouriteCars.favouriteCar = $self;

}

//managed entity contains createdBy, modifiedBy ,createdAt,modifiedAt additonal columns,if we dont we want we can exclude managed inheritance

entity CarFavourites  {
    key favkeyId	      : Integer;
     userId               : String(1111);    
     favouriteCarBrand    : Association to CarBrandInfo;
     favouriteCar         : Association to CarInfo;
     isLiked		      : Boolean;//isLiked column not required ,just inerert/delete row on toggle also sufficent?

}
