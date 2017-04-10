import java.util.Scanner;


public class Demo {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		boolean quit = false;
		
		System.out.println("Welcome to M.G.G.A.");
		System.out.println("Please enter your name: ");
		Manager app = new Manager(new Prof(kb.nextLine()));

		while (quit==false) {	
			if (app.getCourses()==null) {
				System.out.println("No courses found. Please add a course.");
			}
			
		}//end of program while loop
		//save groups.txt below this line

	}
	
	public static void menu () {
		System.out.println("Main Menu: ");
		System.out.println("");
	}

}
