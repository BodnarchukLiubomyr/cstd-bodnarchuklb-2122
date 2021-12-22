package com.company.model.testDao;

import com.company.model.dao.UserDAO;
import com.company.model.entity.place.Place;
import com.company.model.entity.user.Role;
import com.company.model.entity.user.User;
import com.company.model.entity.user.UserDetails;

import java.sql.SQLException;

public class testUser {
    public static void main(String[] args) throws SQLException {
        User user = new User();
        UserDetails details = new UserDetails();
        Place place = new Place();
        user.setId(1);
        user.setLogin("liubomur");
        user.setPassword("admin");
        user.setRole(Role.ADMIN);
        user.setDetails(details);
        user.setPlace(place);
        details.setFirstnameEn("jhghjhj");
        details.setLastnameEn("ghjhvghvh");
        details.setFirstnameUa("ddgdfgddfg");
        details.setLastnameUa("dcsdfdfsdf");
        details.setEmail("liubomyr@gmail.com");
        details.setPhone("9809857734");
        place.setStreet("dfsdfd");
        place.setDistrict("ddsfsdf");
        place.setCity("fsdfsdfdf");
        UserDAO dao = new UserDAO();
        dao.insertUser(user);
        dao.getUserDetails(1);
        dao.selectPlace(1);
        System.out.println(dao.getUser("liubomur").getPassword());
    }
}
