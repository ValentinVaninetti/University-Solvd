package com.solvd.entities.library;

import com.solvd.interfaces.library.ILibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;
import java.util.stream.Collectors;

public class Library implements ILibrary {
    private static final Logger LOGGER = LogManager.getLogger(Library.class);
    private List<Book> bookList;
    private String university; // belongs to which university.
    private static final boolean RETIRED = true;

    public Library(List<Book> bookList, String universityName) {
        this.bookList = bookList;
        this.university = universityName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return this.getUniversity();
    }

    @Override
    public Book withdrawBook(String bookName) {
        List<Book> myBook = getBook(bookName);
        if (!myBook.isEmpty()) {
            myBook.get(0).setRetired(RETIRED);
            return myBook.get(0);
        } else {
            LOGGER.info("Book not found or already retired");
            return null;
        }
    }

    private List<Book> getBook(String bookName) {
        return bookList.stream()
                .filter(book -> book.getName().equals(bookName) && !book.isRetired())
                .collect(Collectors.toList());
    }

    @Override
    public void returnBook(Book book) {
        for (Book b : bookList) {
            if (b.equals(book) && b.isRetired()) {
                b.setRetired(false);
                LOGGER.info("Thank you for Returning the book");
            }
        }
    }

    public int getTotalBooks() {
        return bookList.size();
    }

    public void getBooksByType() {
    }
}
