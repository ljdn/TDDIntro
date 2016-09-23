package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */
    private String title;
    private List<String> books;
    private PrintStream printStream;
    private DateTime time;
    private DateTimeFormatter dateTimeFormatter;

    @Before
    public void setUp() {
        books = new ArrayList<>();
        title = "Book Title";
        printStream = mock(PrintStream.class);
        time = new DateTime();
        dateTimeFormatter = mock(DateTimeFormatter.class);
    }


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        Library library = new Library(books, printStream, dateTimeFormatter);
        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        // implement me
        Library library = new Library(books, printStream, dateTimeFormatter);
        library.listBooks();
        verify(printStream, never()).println();
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        // implement me
        books.add(title);
        books.add(title);
        Library library = new Library(books, printStream, dateTimeFormatter);
        library.listBooks();
        verify(printStream, times(2)).println("Book Title");
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {

        Library library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class

        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {

        when(dateTimeFormatter.print(time)).thenReturn("");
        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        // add a verify here
        verify(printStream).println("Welcome to the library! The current time is ");
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

        // implement me
        when(dateTimeFormatter.print(time)).thenReturn("12:12:12");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        // then move common test variables into a setup method
        verify(printStream).println(contains("12:12:12"));
    }
}
