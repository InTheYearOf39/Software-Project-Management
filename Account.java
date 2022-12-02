package tests;

public class Account {
	 float principal;
	 float rate;
	 int daysActive;
	 int accountType;
	 	
	 	    public static final int  STANDARD = 0;
	 	    public static final int  BUDGET = 1;
	 	    public static final int  PREMIUM = 2;
	 	    public static final int  PREMIUM_PLUS = 3;
	 	    
	 	     // The functions on line 20 used to calculate compound interest was being used to figure out how much interest was earned on the account was removed 
	 	     // and added to the class Accounts and a method called interest added since it used data available in Accounts.
	 	
	 	    
	 	    // next step was making the interestEarned() a clearer calculation since the previous had many calculations being executed in one line 
	 	    // and transforming it to a more discrete function 
	 	    float interestEarned() {
	 	        float years = daysActive / (float) 365.25;
	 	        float compoundInterest = principal * (float) Math.exp( rate * years );
	 	        return ( compoundInterest - principal );
	 	    }
	 	    // A isPremium function was added to the Account class (lines 17 to 22) to check whether the account was a premium account.
	 	    
	 	    public boolean isPremium() {
	 	        if (accountType == Account.PREMIUM || accountType == Account.PREMIUM_PLUS)
	 	            return true;
	 	        else
	 	            return false;
	 	    }
	 	
	 	
	 	float calculateFee(Account accounts[]) {
	 	    float totalFee = 0;
	 	    Account account;
	 	    for (int i = 0; i < accounts.length; i++) {
	 	        account = accounts[i];
	 	        if ( account.isPremium() ) {
	 	            totalFee += BROKER_FEE_PERCENT * account.interestEarned();
	 	        }
	 	    }
	 	    return totalFee;
	 	}
	 	
	 static final double BROKER_FEE_PERCENT = 0.0125;


}
