package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		DefaultLibrary.fillTheLibrary();
		Scanner sc = new Scanner(System.in);

		System.out.println("sveiki atvykę į online knygyną!");
		while(true){
			info();
			int option = sc.nextInt();
			sc.nextLine();
			switch (option){
				case 1 :
					Author.showAuthors();
					break;
				case 2 :
					Book.showBooks();
					break;
				case 3 :
					System.out.println("Įveskite autoriaus vardą");
					Author au = new Author();
					au.setName(sc.nextLine());
					System.out.println("Įveskite autoriaus pavardę");
					au.setSurname(sc.nextLine());
					System.out.println("Autorius buvo sėkmingai įtrauktas į biblioteką");
					break;
				case 4 :
					System.out.println("Įveskite autoriaus id");
					Author a = Author.findAuthorById(sc.nextInt());
					if(a.getId() != 0){
						System.out.println(a);
						for (int i = 0; i < a.getBooks().size(); i++) {
							System.out.println(a.getBooks().get(i));
						}
					}else{
						System.out.println("Tokio autoriaus nera");
					}
					sc.nextLine();
					break;
				case 5 :
					System.out.println("Įveskite autoriaus kurį norite redaguoti id");
					Author.editAuthor(sc);
					break;
				case 6 :
					System.out.println("Įveskite autoriaus kurį norite trinti id");
					Author.deleteAuthor(sc.nextInt());
					sc.nextLine();
					break;
				case 7 :
					System.out.println("Įveskite autoriaus id kuriam norėsite įdėti knygą");
					Author aut = Author.findAuthorById(sc.nextInt());
					sc.nextLine();
					Book bo = new Book();
					System.out.println("Įveskite knygos pavadinimą");
					bo.setTitle(sc.nextLine());
					System.out.println("Įveskite knygos žanrą");
					bo.setGenre(sc.nextLine());
					aut.addBook(bo);
					System.out.println("Knyga buvo sėkmingai pridėta");
					break;
				case 8 :
					System.out.println("Įveskite knygos id");
					Book b =Book.findBookById(sc.nextInt());
					if(b.getId() != 0){
						System.out.println(b);
					}else{
						System.out.println("Tokios knygos nera");
					}
					sc.nextLine();
					break;
				case 9 :
					System.out.println("Įveskite knygos kurią norite redaguoti id");
					Book.workWithBook(sc.nextInt(),"update",sc);
					sc.nextLine();
					break;
				case 10 :
					System.out.println("Įveskite knygos kurią norite trinti id");
					Book.workWithBook(sc.nextInt(),"delete",sc);
					break;
				case 11 :
					System.exit(1);
					break;
				case 12 :
					System.out.println("Įveskite ieškomo autoriaus vardo ar pavardės fragmentą");
					ArrayList<Author> fileredAuthors = Author.searchAuthors(sc.nextLine());
					for (int i = 0; i < fileredAuthors.size() ; i++) {
						System.out.println(fileredAuthors.get(i));
					}
					if(fileredAuthors.size() == 0){
						System.out.println("Deje tokio autoriaus neradome.");
					}
					break;
				case 13 :
					System.out.println("Įveskite ieškomos knygos pavadinimo fragmentą");
					ArrayList<Book> fileredBooks = Book.searchBooks(sc.nextLine());
					for (int i = 0; i < fileredBooks.size() ; i++) {
						System.out.println(fileredBooks.get(i));
					}
					if(fileredBooks.size() == 0){
						System.out.println("Deje tokios knygos neradome.");
					}
					break;
			}
		}
	}

	public static void info(){
		System.out.println("1. Pamatyti autorių sąrašą");//+
		System.out.println("2. Pamatyti knygų sąrašą");//+
		System.out.println("3. Pridėti autorių");//+
		System.out.println("4. Peržiūrėti autorių");//+
		System.out.println("12. Autorių paieška pagal vardą ar pavardę");//+
		System.out.println("5. Redaguoti autorių");//+
		System.out.println("6. Trinti autorių");//+
		System.out.println("7. Pridėti knygą");//+
		System.out.println("8. Peržiūrėti knygą");//+
		System.out.println("13. Knygos paieška pagal pavadinimą");//+
		System.out.println("9. Redaguoti knygą");//+
		System.out.println("10. Trinti knygą");//+
		System.out.println("11. Išeiti iš programos");//+
	}







}
