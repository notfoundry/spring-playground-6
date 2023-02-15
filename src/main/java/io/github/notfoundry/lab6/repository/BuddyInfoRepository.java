package io.github.notfoundry.lab6.repository;

import io.github.notfoundry.lab6.model.BuddyInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "buddyinfo")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
}
