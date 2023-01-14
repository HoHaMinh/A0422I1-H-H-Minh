package com.exercise.blog_app_security.repository;

import com.exercise.blog_app_security.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAccountRepository extends PagingAndSortingRepository<Account, Long> {
    Account findByAccountName(String accountName);
}
