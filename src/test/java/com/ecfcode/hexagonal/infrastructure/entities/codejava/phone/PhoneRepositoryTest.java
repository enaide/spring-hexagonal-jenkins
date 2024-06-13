package com.ecfcode.hexagonal.infrastructure.entities.codejava.phone;

import com.ecfcode.hexagonal.infrastructure.demo.entities.phone.Phone;
import com.ecfcode.hexagonal.infrastructure.demo.entities.phone.PhoneID;
import com.ecfcode.hexagonal.infrastructure.demo.entities.phone.PhoneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class PhoneRepositoryTest {

    @Autowired
    private PhoneRepository phoneRepository;

    @Test
    void testListAll() {
        List<Phone> phones = phoneRepository.findAll();
        assertThat(phones).isNotEmpty();
        phones.forEach(System.out::println);
    }

    @Test
    void testSaveNew() {
        PhoneID phoneID = new PhoneID(1, "123456789");
        Phone contact = new Phone(
                phoneID,
                "Enaide",
                "Corrales"
        );

        Phone phone = phoneRepository.save(contact);
        assertThat(phone).isNotNull();
    }

    @Test
    void testFindById() {
        PhoneID phoneID = new PhoneID(1, "123456789");
        Optional<Phone> phone = phoneRepository.findById(phoneID);
        assertThat(phone).isPresent();
    }
}