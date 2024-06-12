package com.ecfcode.hexagonal.infrastracture.entities.codejava.airport;

import com.ecfcode.hexagonal.infrastracture.demo.entities.airport.Airport;
import com.ecfcode.hexagonal.infrastracture.demo.entities.airport.AirportID;
import com.ecfcode.hexagonal.infrastracture.demo.entities.airport.AirportRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class AirportRepositoryTest {

    @Autowired
    private AirportRepository airportRepository;

    @Test
    void testListAll() {
        List<Airport> airports = airportRepository.findAll();
        assertThat(airports).isNotEmpty();
        airports.forEach(System.out::println);
    }

    @Test
    void testSaveNew() {
        Airport airport = new Airport();
        airport.setCityCode("HAV");
        airport.setCountryCode("CUB");
        airport.setName("Jose Martí International Airport");
        Airport airport1 = airportRepository.save(airport);
        assertThat(airport1).isNotNull();
    }

    @Test
    void findById() {
        AirportID id = new AirportID();
        id.setCityCode("HAV");
        id.setCountryCode("CUB");

        Optional<Airport> result = airportRepository.findById(id);
        assertThat(result).isPresent();
    }
}