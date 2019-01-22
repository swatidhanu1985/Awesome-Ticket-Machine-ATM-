import java.util.List;

public class TIS_Test {

	 private static TIS_Test test = new TIS_Test();
	 
	 
	 // Prepare Data for test
		static TIS_PrepareSystem prepare = new TIS_PrepareSystem();
		static List<TIS_Ticket> ticketTypes = prepare.generateTickets();
		static List<MHS_Bank> bankAccounts = prepare.generateBankAccounts();

		TIS_Main main = new TIS_Main();
		static TIS_Transaction transaction = new TIS_Transaction();
	 
	 public static boolean isAccountNumberValid_Test(String accountNumber) {
		 
		return transaction.checkAccountNumberIfValid(accountNumber, bankAccounts);
	}
	
	public static boolean getTicketPrice_Test(int ticketType, double ticketPriceToCompare) {
	
		return ticketPriceToCompare == transaction.getTicketPrice(ticketTypes, ticketType);
	}
	
	public static boolean getTicketTypeName_Test(int ticketTypeId, String ticketNameToCompare) {
	
		return ticketNameToCompare == transaction.getTicketTypeName(ticketTypes, ticketTypeId);
	}
	
	public static boolean isPaymentSuccessful_Test(int ticketTypeId, String accountNumber) {
	
		return transaction.deductBalance(accountNumber, bankAccounts, ticketTypes, ticketTypeId);
	}

	
	public static void main(String[] args) throws Exception{
	    int totalAmountOfErros = 0;
		
		
	    if(isAccountNumberValid_Test("1234-000001")){
	      System.out.printf("AccountNumber 1234-000001 is valid\n", "PASSED");
	    } else {
	      System.out.printf("AccountNumber 1234-000001 is valid\n", "FAILED");
	      totalAmountOfErros++;
	    }
		
		if(!isAccountNumberValid_Test("0000-000001")){
	      System.out.printf("AccountNumber 0000-000001 is Invalid\n", "PASSED");
	    } else {
	      System.out.printf("AccountNumber", "FAILED");
	      totalAmountOfErros++;
	    }
		
		
		if(getTicketPrice_Test(2, 15.50)){
	      System.out.printf( "Ticket price for Young is 15.50\n", "PASSED");
	    } else {
	      System.out.printf("Ticket price for Young is 15.50\n", "FAILED");
	      totalAmountOfErros++;
	    }
		
		if(getTicketTypeName_Test(2, "Young")){
	      System.out.printf("2nd ticket type is Young\n", "PASSED");
	    } else {
	      System.out.printf("2nd ticket type is Young\n", "FAILED");
	      totalAmountOfErros++;
	    }
		
		if(isPaymentSuccessful_Test(2, "1234-000001")){
	      System.out.printf("Payment is succussful\n", "PASSED");
	    } else {
	      System.out.printf("Payment is succussful\n", "FAILED");
	      totalAmountOfErros++;
	    }
	}
}
	 


	 

