package com.twu28.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private List<Book> bookList;
    private List<User> userList;
    private List<Movie> movieList;
    private User loggedInUser;

    private void populateBooks() {
        for (int iterator = 1; iterator < 10; iterator++) {
            Book book = new Book(iterator + "", "BOOK" + iterator);
            bookList.add(book);
        }
    }

    private void populateUsers() {
        int libraryNumber = 1111111;
        StringBuffer numberBuffer;
        User user;
        for (int iterator = 1; iterator < 10; iterator++, libraryNumber++) {
            numberBuffer = new StringBuffer(Integer.toString(libraryNumber, 10));
            numberBuffer.insert(3, '-');
            try {
                user = new User(numberBuffer.toString(), "password");
            } catch (Exception e) {
                return;
            }
            userList.add(user);
        }
    }

    private void populateMovieList() {
        for (int iterator = 1; iterator <= 10; iterator++) {
            Movie movie = new Movie("Movie" + iterator, "Director" + iterator, iterator);
            movieList.add(movie);
        }
        for (int iterator = 11; iterator <= 15; iterator++) {
            Movie movie = new Movie("Movie" + iterator, "Director" + iterator);
            movieList.add(movie);
        }
    }

    public Application() {
        bookList = new ArrayList<Book>();
        userList = new ArrayList<User>();
        movieList = new ArrayList<Movie>();
        populateBooks();
        populateMovieList();
        populateUsers();
    }

    public String readInput() {
        BufferedReader readInput = new BufferedReader(new InputStreamReader(System.in));
        try {
            return readInput.readLine();
        } catch (Exception e) {
            System.out.println("Exception while reading from console. Exception details - " + e.getMessage());
        }
        return null;
    }

    private Book getBookById(String bookId) {
        for (Book eachBook : bookList) {
            if (eachBook.getBookId().equals(bookId))
                return eachBook;
        }
        return null;
    }

    private Book getBook() {
        System.out.print("Enter The Book Id   :   ");
        String bookId = readInput();
        return getBookById(bookId);
    }

    private boolean reserveAndInform(Book bookOfInterest) {
        if (bookOfInterest == null || !bookOfInterest.reserveBook())
            return false;
        else
            return true;
    }

    private void printRating(Movie eachMovie) {
        if (eachMovie.getRating() == 0)
            System.out.println("N/A");
        else
            System.out.println(eachMovie.getRating());
    }

    private User findUserByUsername(String username) {
        for (User eachUser : userList) {
            if (eachUser.getUsername().equals(username))
                return eachUser;
        }
        return null;
    }

    private void getCredentialsAndAuthenticate() {
        User user;
        System.out.print("Enter the username   :   ");
        String username = readInput();
        System.out.print("Enter the password   :    ");
        String password = readInput();
        user = findUserByUsername(username);
        if (user.confirmAuthentication(username, password))
            loggedInUser = user;
    }

    public void displayBooks() {
        for (Book eachBook : bookList) {
            System.out.println("\n" + eachBook.getBookId() + "  :   " + eachBook.getBookName());
        }
    }

    public void reserveBook() {
        Book bookOfInterest = getBook();
        boolean isReserved = reserveAndInform(bookOfInterest);
        if (isReserved)
            System.out.println("Sorry We don't have that book yet");
        else
            System.out.println("Thank you ! Enjoy the book");
    }

    public void getLibraryNumber() {
        if (loggedInUser == null) {
            System.out.println("Please talk to Librarian. Thank You");
        } else
            System.out.println("Your library number is " + loggedInUser.getUsername());
    }

    public void getMovieList() {
        for (Movie eachMovie : movieList) {
            System.out.print("\n" + eachMovie.getMovieName() + "     " + eachMovie.getDirectorName() + "     ");
            printRating(eachMovie);
        }
    }

    public void login() {
        getCredentialsAndAuthenticate();
        if (loggedInUser == null)
            System.out.println("Invalid username and password");
        else
            System.out.println("The user has logged in successfully");
    }
}
