
import java.util.List;

public class TIS_Transaction {

	public static void main(String[] args) {

		TIS_PrepareSystem prepare = new TIS_PrepareSystem();
		List<TIS_Ticket> ticketTypes = prepare.generateTickets();
		List<MHS_Bank> bankAccounts = prepare.generateBankAccounts();

		TIS_Main main = new TIS_Main();

		int isExit = 0;
		int userChoice;
		int ticketTypeSelected = 0;
		String accountNumber = "";

		while (isExit != 3) {
			main.showMenu();
			userChoice = main.readUsersChoice();

			switch (userChoice) {

			default:
				System.out.println("Wrong Choice!!! Please Try again!!!");
				break;

			case 1:
				main.showTicketOptions(ticketTypes);
				break;
			case 2:
				ticketTypeSelected = main.getTicketType();
				if (ticketTypeSelected < 1 || ticketTypeSelected > 5) {
					System.out.println("Wrong Choice");
					break;
				}

				accountNumber = main.getAccountNumber();
				boolean isValid = checkAccountNumberIfValid(accountNumber, bankAccounts);
				if (isValid) {
					boolean isPaymentSuccess = deductBalance(accountNumber, bankAccounts, ticketTypes,
							ticketTypeSelected);
					if (isPaymentSuccess) {
						displayReceipt(ticketTypeSelected, accountNumber, ticketTypes);
					}

				} else {
					main.showError();
				}
				break;

			case 3:
				isExit = 3;
				System.out.println("System is offline now. Please restart.");
				break;
			}

		}
	}

	private static void displayReceipt(int ticketTypeSelected, String accountNumber, List<TIS_Ticket> ticketTypes) {

		System.out.println("Payment is successful...");

		System.out.println("*******Ticket Receipt********");
		System.out.println("------------------------------\n");
		System.out.println("Ticket Type issued: " + getTicketTypeName(ticketTypes, ticketTypeSelected));
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Ticket price: " + getTicketPrice(ticketTypes, ticketTypeSelected));
		System.out.println("-----Thank you------\n");

	}

	static boolean deductBalance(String accountNumber, List<MHS_Bank> bankAccounts,
			List<TIS_Ticket> ticketTypes, int ticketTypeSelected) {

		boolean isPaymentSuccessful = false;
		for (int i = 0; i < bankAccounts.size(); i++) {
			if (bankAccounts.get(i).accountNr.equals(accountNumber)) {
				double ticketPrice = getTicketPrice(ticketTypes, ticketTypeSelected);

				System.out.println("Your Current Account Balance::" + bankAccounts.get(i).balance);
				if (bankAccounts.get(i).balance > ticketPrice) {
					bankAccounts.get(i).balance = bankAccounts.get(i).balance - ticketPrice;
					isPaymentSuccessful = true;
				} else {
					System.out.println("\n ******Sorry.... Transaction failed... Insufficient balance..!!! \n");
				}
				break;
			}
		}
		return isPaymentSuccessful;

	}

	static boolean checkAccountNumberIfValid(String accountNumber, List<MHS_Bank> accountList) {
		boolean isValid = false;

		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).accountNr.equals(accountNumber)) {
				isValid = true;
				break;
			}
		}
		return isValid;
	}

	static double getTicketPrice(List<TIS_Ticket> ticketTypes, int ticketTypeSelected) {
		return ticketTypes.get(ticketTypeSelected - 1).tPrice;
	}

	static String getTicketTypeName(List<TIS_Ticket> ticketTypes, int ticketTypeSelected) {
		return ticketTypes.get(ticketTypeSelected).type;
	}
}
