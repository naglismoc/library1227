package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Author {
    private static int counter = 0;
    public static ArrayList<Author> authors = new ArrayList<>();

    private int id;
    private String name;
    private String surname;
    private ArrayList<Book> books;

    public Author() {
        this.id = ++counter;
        this.books = new ArrayList<>();
        authors.add(this);
    }

    public Author(int emptyAuthor) {
        this.id = 0;
    }

    public Author( String name, String surname) {
        this.id = ++counter;
        this.name = name;
        this.surname = surname;
        this.books = new ArrayList<>();
        authors.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        book.setAuthorId(this.id);
        this.books.add(book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", surname='" + this.surname + '\'' +
                ", wrote "+ this.books.size() +" book(s)}";
    }

    public static ArrayList<Book> books(){
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < authors.size(); i++) {
            for (int a = 0; a < authors.get(i).books.size(); a++) {
                books.add(authors.get(i).books.get(a));
            }
        }
        return books;
    }

    public static Author findAuthorById(int id){
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).id == id){
                return authors.get(i);
            }
        }
        return new Author(-1);
    }

    public static void showAuthors(){//1
        for (int i = 0; i < Author.authors.size(); i++) {
            Author author = Author.authors.get(i);
            System.out.println(author);
        }
    }

    public static ArrayList<Author> searchAuthors(String word){
        ArrayList<Author> filteredAuthors = new ArrayList<>();
        for (int i = 0; i < authors.size(); i++) {
            if( (authors.get(i).name + " " + authors.get(i).surname)
                .toLowerCase()
                .contains(word.toLowerCase())
            ){
                filteredAuthors.add(authors.get(i));
            }
        }
        return filteredAuthors;
    }

    public static void deleteAuthor(int id){
        for (int i = 0; i < authors.size(); i++) {
            if(authors.get(i).id == id){
                if(authors.get(i).getBooks().size() > 0){
                    System.out.println("Autoriaus trinti negalime, nes jis turi knygų.");
                }else {
                    authors.remove(i);
                    System.out.println("Autorius sėkmingai pašalintas");
                }
            }
        }
    }

    public static void editAuthor(Scanner sc){
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < authors.size(); i++) {
            if(authors.get(i).id == id){
                System.out.println("Įveskite autoriaus vardą");
               authors.get(i).setName(sc.nextLine());
                System.out.println("Įveskite autoriaus pavardę");
                authors.get(i).setSurname(sc.nextLine());
                System.out.println("Autorius sėkmingai atnaujintas");
            }
        }
    }
}

