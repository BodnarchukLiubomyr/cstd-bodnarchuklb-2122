package com.company.model.testDao;

import com.company.model.dao.ServiceDAO;
import com.company.model.dao.TariffDAO;
import com.company.model.dao.TariffStatusDAO;
import com.company.model.entity.tariff.Tariff;

import java.math.BigDecimal;
import java.sql.SQLException;

public class testTariff {
    public static void main(String[] args) throws SQLException {
        Tariff tariff = new Tariff();
        tariff.setId(1);
        tariff.setName_en("Lux tariff");
        tariff.setTime(30);
        tariff.setDescription("The best tariff");
        tariff.setPrice(new BigDecimal(150));
        TariffStatusDAO dao2 = new TariffStatusDAO();
        tariff.setStatus(dao2.selectStatus(1));
        ServiceDAO dao3 = new ServiceDAO();
        tariff.setService(dao3.selectService(1));
        TariffDAO dao = new TariffDAO();
        //dao.insertTariff(tariff);
        System.out.println(dao.selectTariff(1).getName_en());
    }
}
