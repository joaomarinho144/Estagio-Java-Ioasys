package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    boolean existsByUsername(String username);

    User findByUsername(String username);

    Page<User> findByStatusOrderByUsername(Pageable page, int status);

    @Transactional
    void deleteByUsername(String username);
}
