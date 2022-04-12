package com.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.Book;
import com.service.BookService;
import com.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends HttpServlet {
    private static Gson GSON = new GsonBuilder().create();
    private static BookService bookService = new BookServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(request.getPathInfo() == null){
            List<Book> books = bookService.getBooks();
            response.setStatus(200);
            response.setHeader("Content-Type","application/json");
            response.getOutputStream().println(GSON.toJson(books));
        }else {
            int bookId = Integer.parseInt(request.getPathInfo().replace("/",""));
            Book book = bookService.getBookById(bookId);
            if(book != null){
                response.setStatus(200);
                response.setHeader("Content-Type","application/json");
                response.getOutputStream().println(GSON.toJson(book));
            }else {
                response.setStatus(404);
            }
        }
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        Book book = GSON.fromJson(request.getReader(),Book.class);
        bookService.createBook(book);

        response.setStatus(201);
        response.setHeader("Content-Type","application/json");
        response.getOutputStream().println(GSON.toJson(book));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = GSON.fromJson(request.getReader(),Book.class);
        bookService.updateBook(book);

        response.setStatus(201);
        response.setHeader("Content-Type","application/json");
        response.getOutputStream().println(GSON.toJson(book));
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = GSON.fromJson(request.getReader(),Book.class);
        bookService.deleteBook(book);

        response.setStatus(201);
        response.setHeader("Content-Type","application/json");
        response.getOutputStream().println(GSON.toJson(book));
    }
}
