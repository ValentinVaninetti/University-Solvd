package com.solvd.interfaces.library;

import com.solvd.entities.library.Book;

public interface ILibrary {
    /**
     * This method is used to rent a Book from the library book list.
     *
     * @return book
     */
    Book withdrawBook(String bookName);

    /**
     * This method is used when a book has returned to the library book list.
     *
     * @param book1
     */
    void returnBook(Book book1);
}
