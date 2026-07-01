package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void manageLibrary() {
        System.out.println("[SERVICE]: Executing business logic to manage catalog...");
        bookRepository.saveData();
    }
}