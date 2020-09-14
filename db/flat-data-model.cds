namespace com.sap.it.capire.car.model;
//@purpose: Assignment Fulljoin, Views on Car CAP Sample Services data model
//author: I311690
//@since: 27/07/2020
using {
    Currency,
    managed
} from '@sap/cds/common';
entity CarBrandInfoFlat : managed {
    key ID    : String(1111);
        description : String(1111);
        cars  : Association to many CarInfoFlat                   
                    on cars.brand = $self;       

}

entity CarInfoFlat : managed {
    key ID     : String(1111);
        description  : String(1111);
        brand  : Association to CarBrandInfoFlat;   

}

//managed entity contains createdBy, modifiedBy ,createdAt,modifiedAt additonal columns,if we dont we want we can exclude managed inheritance
entity CarBrandFavouritesFlat  {
     key ID     : String(1111);
     isLiked		      : Boolean;
}
entity CarInfoFavouritesFlat  {
     key ID     : String(1111);
     isLiked		      : Boolean;
}
