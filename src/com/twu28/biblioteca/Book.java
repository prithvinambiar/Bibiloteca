package com.twu28.biblioteca;

public class Book {

    private String bookId;
    private String bookName;
    private boolean reserved;

    public Book(String bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public boolean isReserved() {
        return reserved;
    }

    private void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    // good, not breaking encapsulation here.
    public boolean reserveBook() {
        if (this.isReserved())
            return false;

        this.setReserved(true);
        return true;
    }

    public boolean unReserveBook() {
        if (!this.isReserved())
            return false;

        this.setReserved(false);
        return true;
    }
}
