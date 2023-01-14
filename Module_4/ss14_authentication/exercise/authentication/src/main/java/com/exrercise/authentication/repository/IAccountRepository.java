package com.exrercise.authentication.repository;

import com.exrercise.authentication.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAccountRepository extends PagingAndSortingRepository<Account, Long> {
    Account findByAccountName(String accountName);
}
