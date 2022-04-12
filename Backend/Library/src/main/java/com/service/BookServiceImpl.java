package com.service;
import java.util.*;

import com.model.Book;
public class BookServiceImpl implements BookService{
    private   List<Book> bookArrayList = new ArrayList<>();
    @Override
    public Book getBookById(int BookId) {
        for(int i = 0;i<bookArrayList.size();i++){
            if(BookId == bookArrayList.get(i).getBookId()){
                return bookArrayList.get(i);
            }
        }
        return null;
    }

    @Override
    public Book createBook(Book book) {
        bookArrayList.add(book);
        return book;
    }

    @Override
    public Book deleteBook(Book book) {
        for(Book i : bookArrayList){
            if(i.getBookId() == book.getBookId()){
                bookArrayList.remove(i);
            }
        }
        return book;
    }

    @Override
    public Book updateBook(Book book) {

       for(Book i : bookArrayList){
           if(i.getBookId() == book.getBookId()){
               i.setBookId(book.getBookId());
               i.setBookName(book.getBookName());
               i.setBookAuthor(book.getBookAuthor());
           }
       }
        return book;
    }

    @Override
    public List<Book> getBooks() {

            return bookArrayList;
    }
}
