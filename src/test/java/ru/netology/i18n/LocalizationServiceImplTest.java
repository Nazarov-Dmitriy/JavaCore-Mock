package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    @Test void LocalizationServiceImplTestLocaleRussian(){
        var expect = "Добро пожаловать";
        var localizationServiceImplTest = new LocalizationServiceImpl();
        var actual = localizationServiceImplTest.locale(Country.RUSSIA);

        assertEquals(expect ,actual);
    }

    @Test void LocalizationServiceImplTestLocaleBrazil(){
        var expect = "Welcome";
        var localizationServiceImplTest = new LocalizationServiceImpl();
        var actual = localizationServiceImplTest.locale(Country.BRAZIL);

        assertEquals(expect ,actual);
    }
}