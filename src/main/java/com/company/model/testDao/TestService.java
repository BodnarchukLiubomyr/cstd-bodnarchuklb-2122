package com.company.model.testDao;

import com.company.model.dao.ServiceDAO;
import com.company.model.entity.service.Service;

public class TestService {
    public static void main(String[] args) {
        Service service = new Service();
        ServiceDAO dao = new ServiceDAO();
        System.out.println(dao.selectServices());
    }
}
