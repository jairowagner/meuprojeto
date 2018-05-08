package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
