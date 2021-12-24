package com.company.model.testDao;
import com.company.model.dao.PlaceDao;
import com.company.model.entity.place.Place;

public class testPlace {
    public static void main(String[] args) {
        Place place = new Place();
        place.setStreet("test");
        place.setDistrict("fgdfg");
        place.setCity("dvdvdv");
        PlaceDao dao = new PlaceDao();
        dao.insertPlace(place);
        System.out.println(dao.selectPlace(1).getStreet());
    }
}
