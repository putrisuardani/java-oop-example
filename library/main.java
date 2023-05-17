import java.util.Scanner;

class Main {

	static Scanner scan = new Scanner(System.in);
	static Library library = new Library();

	public static void main(String[] args) {
		initLibraryData();

		String isContinue = "y";

		while (isContinue.equals("y")) {
			showMenu();
			int selectedMenu = chooseMenu();

			if (selectedMenu == 1) {
				showBooks();
			} else if (selectedMenu == 2) {
				showMembers();
			} else if (selectedMenu == 3) {
				addBook();
			} else if (selectedMenu == 4) {
				addMember();
			} else if (selectedMenu == 5) {
				borrowBook();
			} else if (selectedMenu == 6) {
				returnBook();
			} else if (selectedMenu == 7 ) {
				deleteMember();
			} else {
				System.out.println("wrong input");
			}

			System.out.print("continue ? ");
			isContinue = scan.next();
		}
	}

	public static void showMenu() {
		System.out.println("================================");
		System.out.println("1. show books list");
		System.out.println("2. show members list");
		System.out.println("3. add book");
		System.out.println("4. add member");
		System.out.println("5. borrow book");
		System.out.println("6. return book");
		System.out.println("7. delete member");
		System.out.println("================================");
	}

	public static void initLibraryData() {
		Book book1 = new Book();
		book1.setId("1");
		book1.setTitle("pemrograman java");

		Book book2 = new Book();
		book2.setId("2");
		book2.setTitle("pemrograman oop");

		Book book3 = new Book();
	    book3.setId("3");
	    book3.setTitle("pemrograman android");
	
	    Member member1 = new Member();
	    member1.id = "1";
	    member1.name = "aka";
	
	    Member member2 = new Member();
	    member2.id = "2";
	    member2.name = "budi";
	
	    Member member3 = new Member();
	    member3.id = "3";
	    member3.name = "tono";
	
	    library.books.add(book1);
	    library.books.add(book2);
	    library.books.add(book3);
	
	    library.members.add(member1);
	    library.members.add(member2);
	    library.members.add(member3);
	}

	public static int chooseMenu() {
		int pilihan = 0;
		try {
			System.out.print("choose menu : ");
			pilihan = scan.nextInt();
		} catch (Exception e) {
			System.out.println("wrong input");
		} 
		return pilihan;
	}

	public static void showBooks() {
    
		for (Book book : library.books) {
			System.out.println(book.getId() + " " + book.getTitle());
		}
	}

	public static void showMembers() {
		for (Member member : library.members) {
			System.out.println(member.id + " " + member.name);
			System.out.println("Buku yang dipinjam: ");
			if (member.borrowedBooks == null) {
				System.out.println("-");
			} else {
				for (Book borrowedBook : member.borrowedBooks) {
					System.out.println(borrowedBook.getId() + borrowedBook.getTitle());
				}
			}
		}
	}

	public static void addMember() {
		Member member = new Member();

		System.out.print("id : ");
		member.id = scan.next();

		System.out.print("name : ");
		member.name = scan.next();

		if (library.isMemberIdExist(member.id)) {
			System.out.println("Member ID Exist! Please use another Member ID");
		} else {
			library.addMember(member);
		}
	}

	public static void addBook() {
		Book book = new Book();

		System.out.print("id : ");
		String bookId = scan.next();
		book.setId(bookId);

		System.out.print("name : ");
		String bookTitle = scan.next();
		book.setTitle(bookTitle);

		if (library.isMemberIdExist(bookId)) {
			System.out.println("Book ID Exist! Please use another Book ID");
		} else {
			library.addBook(book);
		}
	}

	public static void borrowBook() {
		System.out.print("id member : ");
		String memberId = scan.next();

		System.out.print("id book : ");
		String bookId = scan.next();

		library.giveBook(bookId, memberId);
	}

	public static void returnBook() {
		System.out.print("id member : ");
		String memberId = scan.next();

		System.out.print("id book : ");
		String bookId = scan.next();

		library.receiveBook(bookId, memberId);
	}
  
	public static void deleteMember() {
		System.out.print("id : ");
		String id = scan.next();

		library.deleteMember(id);
	}
}