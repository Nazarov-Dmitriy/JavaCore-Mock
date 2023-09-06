package ru.netology.geo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;


class GeoServiceImplTest {
    @Test
    void getGeoServiceImplIpRussuia() {
        var expect = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        var geoServiceImpl = new GeoServiceImpl();
        var actual = geoServiceImpl.byIp("172.0.32.11");
        Assertions.assertEquals(expect.getCity(), actual.getCity());
    }
    @Test
    void getGeoServiceImplIpUsa() {
        var expect = new Location("New York", Country.USA, " 10th Avenue", 32);
        var geoServiceImpl = new GeoServiceImpl();
        var actual = geoServiceImpl.byIp("96.0.32.11");
        Assertions.assertEquals(expect.getCity(), actual.getCity());
    }
}