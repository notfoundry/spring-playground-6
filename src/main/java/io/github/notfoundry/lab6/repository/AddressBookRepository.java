package io.github.notfoundry.lab6.repository;

import io.github.notfoundry.lab6.model.AddressBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "addressbook")
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
    AddressBook findFirstBy();
}
