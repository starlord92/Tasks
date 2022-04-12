package com.service;

import com.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    Book getBookById(int BookId);
    Book createBook(Book book);
    Book updateBook(Book book);
    Book deleteBook(Book book);
}
