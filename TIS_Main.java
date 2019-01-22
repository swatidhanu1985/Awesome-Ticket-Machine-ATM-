import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TIS_Main {

	public void showMenu() {
		// show menu 1. buy 2. exit

		System.out.println("Select Your Choice:");
		System.out.println("1: Show all tickets");
		System.out.println("2: Buy new ticket");
		System.out.println("3: Exit");

		System.out.print("Choose your Choice: ");

	}

	public int readUsersChoice() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();

	}

	public void showTicketOptions(List ticketTypes) {
		System.out.println("------------------------------------------------------------------------------- ");
		for (int i = 0; i < ticketTypes.size(); i++) {
			TIS_Ticket ticket = (TIS_Ticket) ticketTypes.get(i);
			System.out.println(ticket.type + "\t\t" + ticket.tAgeLowerLimit + "-" + ticket.tAgeUpperLimit + "\t"
					+ ticket.tInfo + "\t\t\t\t" + ticket.tPrice);
		}

		System.out.println("-------------------------------------------------------------------------------- ");
		System.out.println("\n");
	}

	public String getAccountNumber() {
		System.out.println("Enter Account number ( Follow this format:12XX-123xxx) :");
		Scanner scan = new Scanner(System.in);
		return scan.next();

	}

	public int getTicketType() {
		System.out.println(
				"Enter ticket type: (1 for child   2 for Young   3 for Adult   4 for senior    5 for Family):");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();

	}

	public void showError() {
		System.out.println("******Account number is incorrect. Try again please.********\n");
	}

}
