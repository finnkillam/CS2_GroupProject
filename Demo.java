import java.io.IOException;
import java.util.Scanner;

public class Demo {
	private static Manager app;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		boolean quit = false;

		System.out.println("Welcome to M.G.G.A.");
		System.out.println("Please enter your name: ");
		app = new Manager(new Prof(kb.nextLine()));

		while (quit == false) {
			// Initial setup
			if (app.getCourses().isEmpty()) {
				tut();

			}
			menu();
			while (!kb.hasNextInt()) {
				System.out.print("Please enter the number of the item");
			}
			int option = kb.nextInt();
			kb.nextLine();
		}// end of program while loop
		

	}// save groups.txt below this line
		


	public static void menu() {
		System.out.println("Main Menu: ");
		System.out.println("1. Add a Course");
		System.out.println("2. Import students to a course");
		System.out.println("3. Add a single student to a course");
		System.out.println("4. Auto-assign groups for a course");
		System.out.println("5. ");
		System.out.println("");
	}

	public static void tut() {
		Scanner kb = new Scanner(System.in);
		System.out.println(
				app.getProf().getName() + ", you currently are not teaching any courses. Please add a course.");
		System.out.println("Please enter the name of the course: ");
		app.addCourse(new Course(kb.nextLine()));
		System.out.println("Would you like to import a student list? (Y/N)");
		String answer = kb.next();
		kb.nextLine();
		if (answer.equalsIgnoreCase("y")) {
			System.out.println("Ok, please enter the name of the Students file: ");
			String stuFile = kb.nextLine();
			System.out.println("Now enter the name of the Student ID file: ");
			String idFile = kb.nextLine();
			System.out.println("Now enter the name of the Student Grades file: ");
			String gradesFile = kb.nextLine();
			try {
				app.getCourses().get(0).importStudents(stuFile, idFile, gradesFile);
			} catch (IOException e) {
				System.out.println("Sorry, there was an error reading the file.");
			}
		}
	}

}
