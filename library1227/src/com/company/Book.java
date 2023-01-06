package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private static int counter = 0;
    private int id;
    private String title;
    private String genre;
    private int authorId;

    public Book() {
        this.id = ++counter;

    }

    public Book(int emptyBook) {
    }

    public Book(String title, String genre, int authorId) {
        this.id = ++counter;
        this.title = title;
        this.genre = genre;
        this.authorId = authorId;
    }

    public Book(String title, String genre) {
        this.id = ++counter;
        this.title = title;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", authorId=" + authorId +
                ", author=" + getAuthorInitials() +
                '}';
    }

    public String getAuthorInitials(){
        for (int i = 0; i < Author.authors.size(); i++) {
            if(Author.authors.get(i).getId() == this.authorId){
               return Author.authors.get(i).getName() + " " + Author.authors.get(i).getSurname();
            }
        }
        return "";
    }

    public static void showBooks(){//2
        for (int i = 0; i < Author.books().size(); i++) {
            Book book = Author.books().get(i);
            System.out.println(book);
        }
    }

    public static Book findBookById(int id){
        for (int i = 0; i < Author.books().size(); i++) {
            if(Author.books().get(i).id == id){
                return Author.books().get(i);
            }
        }
        return new Book(-1);
    }

    public static ArrayList<Book> searchBooks(String word){
        ArrayList<Book> books = Author.books();
        ArrayList<Book> filteredBooks = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if( books.get(i).title.toLowerCase().contains(word.toLowerCase())){
                filteredBooks.add(books.get(i));
            }
        }
        return filteredBooks;
    }

    public static void workWithBook(int id, String whatToDo, Scanner sc){
        sc.nextLine();
        ArrayList<Book> books = Author.books();
        int authorId = 0;
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).id == id){
                authorId = books.get(i).getAuthorId();
                break;
            }
        }
        if(authorId == 0){
            System.out.println("Deje neradome tokios knygos");
            return;
        }
        Author a = Author.findAuthorById(authorId);
        if (a.getId() == 0){
            System.out.println("Deje neradome tokios knygos");
            return;
        }
        for (int i = 0; i < a.getBooks().size(); i++) {
            if(a.getBooks().get(i).id == id){
                if(whatToDo == "delete"){
                a.getBooks().remove(i);
                System.out.println("Knyga buvo sėkmingai pašalinta");
                }
                if (whatToDo == "update"){
                    System.out.println("Įveskite knygos padavinimą");
                    a.getBooks().get(i).setTitle(sc.nextLine());
                    System.out.println("Įveskite knygos žanrą");
                    a.getBooks().get(i).setGenre(sc.nextLine());
                    System.out.println("knyga sėkmingai atnaujinta");
                }
                break;
            }
        }
    }

}
