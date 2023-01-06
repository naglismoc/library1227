package com.company;

public class DefaultLibrary {

    public static void fillTheLibrary(){
        Author a0 = new Author("Juozas","Erlickas");
        a0.addBook(new Book("Grybų karas ir taika","absurdo komedija"));
        a0.addBook(new Book("Niekas nenorėjo mirti. Gyventi taip pat","absurdo komedija"));

        Author a1 = new Author("Kažkokia", "Čiolė");
        a1.addBook(new Book("Kakės makės","tiesiog absurdas"));

        Author a2 = new Author("Kažkas kas","Jau mirė");
        a2.addBook(new Book("Baltoji iltis","romanas"));
        a2.addBook(new Book("Raudonasis korsaras","drama"));

        Author a3 = new Author("Gitanas","Nausėda");

        Author a4 = new Author("J.R.R", "Tolkien");
        a4.addBook(new Book("Žiedų valdovas 1","fantastika"));
        a4.addBook(new Book("Žiedų valdovas 2","fantastika"));
        a4.addBook(new Book("Žiedų valdovas 3","fantastika"));
        a4.addBook(new Book("Žiedų valdovas 4","fantastika"));
        a4.addBook(new Book("Žiedų valdovas 5","fantastika"));
        a4.addBook(new Book("Žiedų valdovas 6","fantastika"));
        a4.addBook(new Book("Žiedų valdovas 7","fantastika"));
    }
}
