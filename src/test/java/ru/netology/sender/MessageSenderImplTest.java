package ru.netology.sender;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
class MessageSenderImplTest {
    @Test
    void getMessageSenderImplTestRussianIp() {
        var expect = "Добро пожаловать";

        var geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        var location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Mockito.when(geoServiceImpl.byIp(Mockito.any(String.class))).thenReturn(location);

        var localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);
        var country = "Добро пожаловать";
        Mockito.when(localizationServiceImpl.locale(Mockito.any(Country.class))).thenReturn(country);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");

        var messageSenderImpl = new MessageSenderImpl(geoServiceImpl, localizationServiceImpl);

        var actual = messageSenderImpl.send(headers);

        Mockito.verify(geoServiceImpl,Mockito.times(1)).byIp(Mockito.any(String.class));
        Mockito.verify(localizationServiceImpl,Mockito.times(2)).locale(location.getCountry());

        Assertions.assertEquals(expect, actual);
    }

    @Test
    void getMessageSenderImplTestUsaIp() {
        var expect = "Welcome";

        var geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        var location = new Location("New York", Country.USA, " 10th Avenue", 32);
        Mockito.when(geoServiceImpl.byIp(Mockito.any(String.class))).thenReturn(location);

        var localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);
        var country = "Welcome";
        Mockito.when(localizationServiceImpl.locale(Mockito.any(Country.class))).thenReturn(country);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        var messageSenderImpl = new MessageSenderImpl(geoServiceImpl, localizationServiceImpl);

        var actual = messageSenderImpl.send(headers);

        Mockito.verify(geoServiceImpl,Mockito.times(1)).byIp(Mockito.any(String.class));
        Mockito.verify(localizationServiceImpl,Mockito.times(2)).locale(location.getCountry());

        Assertions.assertEquals(expect, actual);
    }
}

