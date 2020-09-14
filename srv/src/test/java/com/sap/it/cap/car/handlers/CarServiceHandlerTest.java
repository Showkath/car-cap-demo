package com.sap.it.cap.car.handlers;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import cds.gen.carservice.CarInfo;
import cds.gen.carservice.CarService_;

//import cds.gen.carservice.Books;
import com.sap.it.cap.car.handlers.CarServiceHandler;

public class CarServiceHandlerTest {

    private CarServiceHandler handler = new CarServiceHandler();
   
	private CarInfo carInfo = CarInfo.create();

	@Before
	public void prepareCar() {
        carInfo.setId("Car");
		carInfo.setDescr("Car");
	}

	@Test
	public void testDiscount() {
		carInfo.setStock(900);
		handler.discountCars(Stream.of(carInfo));
		assertEquals("Car ( * discounted)", carInfo.getDescr());
	}

	@Test
	public void testNoDiscount() {
		carInfo.setStock(100);
		handler.discountCars(Stream.of(carInfo));
		assertEquals("Car", carInfo.getDescr());
	}

	@Test
	public void testNoStockAvailable() {
		handler.discountCars(Stream.of(carInfo));
		assertEquals("Car", carInfo.getDescr());
	}

}