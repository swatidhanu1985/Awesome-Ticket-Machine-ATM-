import java.util.ArrayList;
import java.util.List;

public class TIS_PrepareSystem {

	public List<MHS_Bank> generateBankAccounts() {

		List<MHS_Bank> bankAccounts = new ArrayList<MHS_Bank>();
		bankAccounts.add(new MHS_Bank("Nordea", "1234-000001", 25));
		bankAccounts.add(new MHS_Bank("Nordea", "1234-000002", 1000));
		bankAccounts.add(new MHS_Bank("Nordea", "1234-000003", 1000));
		bankAccounts.add(new MHS_Bank("HandelBanken", "1432-000001", 1000));
		bankAccounts.add(new MHS_Bank("HandelBanken", "1432-000002", 1000));
		bankAccounts.add(new MHS_Bank("HandelBanken", "1432-000003", 1000));
		bankAccounts.add(new MHS_Bank("SEB", "5531-000001", 1000));
		bankAccounts.add(new MHS_Bank("SEB", "5531-000002", 1000));
		bankAccounts.add(new MHS_Bank("SEB", "5531-000003", 1000));
		bankAccounts.add(new MHS_Bank("Swedbank", "9951-000001", 1000));
		bankAccounts.add(new MHS_Bank("Swedbank", "9951-000002", 1000));
		bankAccounts.add(new MHS_Bank("Swedbank", "9951-000003", 1000));

		System.out.println("Bank Types created....");
		return bankAccounts;
	}

	public List<TIS_Ticket> generateTickets() {
		List<TIS_Ticket> ticketTypes = new ArrayList<TIS_Ticket>();

		ticketTypes.add(new TIS_Ticket("Child", 0, 10, "For alla personer som fyllt minst 1 �r och max 10 �r", 10.00));
		ticketTypes
				.add(new TIS_Ticket("Young", 11, 17, "F�r alla personer som fyllt minst 11 �r och max 17 �r", 15.50));
		ticketTypes
				.add(new TIS_Ticket("Adult", 18, 64, "F�r alla personer som fyllt minst 18 �r och max 64 �r", 22.50));
		ticketTypes.add(new TIS_Ticket("Senior", 65, 100, "F�r alla personer som fyllt minst 64 �r",           15.00));
		ticketTypes.add(new TIS_Ticket("Family", 0, 0, "F�r en samling av personer, best�ende av",             40.00));
		ticketTypes.add(new TIS_Ticket(" ", 0, 0, "Minst 1 Adult eller Senior, max 2 Adult eller Senior", 0));
		ticketTypes.add(new TIS_Ticket("  ", 0, 0, "Minst 1 child, max 3 child",                            0));

		System.out.println("Ticket types loaded.....");

		return ticketTypes;
	}

}
