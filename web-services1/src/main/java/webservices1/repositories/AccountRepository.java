package webservices1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import webservices1.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findOneByName(String accountName);
}
