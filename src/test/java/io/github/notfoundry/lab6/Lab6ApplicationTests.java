package io.github.notfoundry.lab6;

import com.jayway.jsonpath.JsonPath;
import io.github.notfoundry.lab6.model.AddressBook;
import io.github.notfoundry.lab6.model.BuddyInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class Lab6ApplicationTests {

//    private final RestTemplate restTemplate = new RestTemplate();
//
//    @Test
//    void testQueryingAndCreatingAddressBooks() {
//        // 1. Query all AddressBook instances
//        ResponseEntity<String> resp = this.restTemplate.getForEntity("http://localhost:8080/api/addressbook", String.class);
//        assertEquals(resp.getStatusCode().value(), 200);
//
//        // 2. Verify that no instances were found
//        AddressBook[] addressBooks = JsonPath.parse(resp.getBody()).read("_embedded.addressBooks", AddressBook[].class);
//        assertEquals(addressBooks.length, 0);
//
//        // 3. Create a new AddressBook instance
//        AddressBook newAddressBook = new AddressBook();
//        newAddressBook.addBuddy(new BuddyInfo("A", "B", "C", "D"));
//        HttpEntity<AddressBook> request = new HttpEntity<>(newAddressBook);
//        AddressBook foundAddressBook = this.restTemplate.postForObject("http://localhost:8080/api/addressbook", request, AddressBook.class);
//
//        // 4. Query all AddressBook instances again
//        resp = this.restTemplate.getForEntity("http://localhost:8080/api/addressbook", String.class);
//        assertEquals(resp.getStatusCode().value(), 200);
//
//        // 5. Verify that the new instance was found
//        assertTrue(JsonPath.parse(resp.getBody()).jsonString().contains("{\"buddies\":[{\"firstName\":\"A\",\"lastName\":\"B\",\"address\":\"C\",\"telephoneNum\":\"D\"}"));
//    }
//
//    @Test
//    void testQueryingAddressBooks() {
//        // 1. Query all AddressBook instances
//        ResponseEntity<String> resp = this.restTemplate.getForEntity("http://localhost:8080/api/addressbook", String.class);
//        assertEquals(resp.getStatusCode().value(), 200);
//
//        // 2. Verify that no instances were found
//        AddressBook[] addressBooks = JsonPath.parse(resp.getBody()).read("_embedded.addressBooks", AddressBook[].class);
//        assertEquals(addressBooks.length, 0);
//    }
}
