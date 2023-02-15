package io.github.notfoundry.lab6.controller;

import io.github.notfoundry.lab6.model.AddressBook;
import io.github.notfoundry.lab6.model.BuddyInfo;
import io.github.notfoundry.lab6.repository.AddressBookRepository;
import io.github.notfoundry.lab6.repository.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AddressBookController {
    private final AddressBookRepository addressBookRepository;

    private final BuddyInfoRepository buddyInfoRepository;

    @Autowired
    public AddressBookController(final AddressBookRepository addressBookRepository, final BuddyInfoRepository buddyInfoRepository) {
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

    @ExceptionHandler(DataRetrievalFailureException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody String handleException(DataRetrievalFailureException e) {
        return e.getMessage();
    }

    @GetMapping("/editor")
    public String getAddressBookEditor(Model model) {
        model.addAttribute("addressbooks", this.addressBookRepository.findAll());
        return "editor";
    }

    @PostMapping(value = "/editor/addressbook", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String createAddressBookFromEditor(AddressBook addressBook) {
        this.addressBookRepository.save(addressBook);
        return "redirect:/editor";
    }

    @PostMapping(value = "/editor/addressbook/{id}/buddyinfo", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String createBuddyInfoFromEditor(@PathVariable("id") Long id, BuddyInfo buddyInfo) {
        buddyInfo.setId(null);
        final Optional<AddressBook> addressBookQuery = this.addressBookRepository.findById(id);
        final AddressBook addressBook = addressBookQuery.orElseThrow(() -> new DataRetrievalFailureException(String.format("Could not find AddressBook with id %s", id)));

        buddyInfo = this.buddyInfoRepository.save(buddyInfo);
        addressBook.addBuddy(buddyInfo);
        addressBookRepository.save(addressBook);

        return "redirect:/editor";
    }

}
