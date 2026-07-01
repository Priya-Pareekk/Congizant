package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("--- Bootstrapping Spring Application Context ---");

        // Load the Spring XML application context configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the fully wired BookService bean from IoC container
        BookService service = (BookService) context.getBean("bookService");

        // Execute the service layer method to verify configuration and DI status
        service.manageLibrary();

        System.out.println("--- Spring Core Core DI Operations Verified ---");
    }
}