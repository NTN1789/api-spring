package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.Book;

@Repository
public interface BookRepositories  extends JpaRepository<Book, Long>{

}
