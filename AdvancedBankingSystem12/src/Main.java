import java.util.Scanner;

import com.codegnan.dao.AccountDao;
import com.codegnan.dao.TranscationDao;
import com.codegnan.dao.UserDao;
import cm.codgnan.service.AuthinticationService;
import cm.codgnan.service.ConcurentTransctionService;
import cm.codgnan.service.ExportService;
import cm.codgnan.service.InterestService;
import model.CurrentAccount;
import model.SavingsAccount;
import model.User;

public class Main {


	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		UserDao userdao=new UserDao();
		AccountDao accountdao=new AccountDao();
		TranscationDao transactiondao=new TranscationDao();
		User admin=new User("U101","surendra_LS","securepass123");
		userdao.save(admin);

		SavingsAccount sa=new SavingsAccount("sa-1001","U102",5000.0,4.5);
		CurrentAccount ca=new CurrentAccount("ca-2001","U101",10000.0,1000.0);
		accountdao.save(ca);
		accountdao.save(sa);
		
		AuthinticationService authserv=new AuthinticationService(userdao);
		ConcurentTransctionService txn=new ConcurentTransctionService(accountdao,transactiondao);
		InterestService intserv=new InterestService(accountdao);
		ExportService expserv=new ExportService(transactiondao);
		try {
			System.out.println("enter the login userid and password");
			String username=sc.nextLine();
			String userpass=sc.nextLine();
			User LoggedIn=authserv.authenticate(username,userpass);
			System.out.println("Authentication successful!\n");
			boolean running=true;
			while(running) {
			System.out.println("Authintication succesfully");
			System.out.println("enter the choice");
			System.out.println("1. Deposit ");
			System.out.println("2. Transfer");
			System.out.println("3. Interest caluculatar");
			System.out.println("4. withdraw");
			System.out.println("5. Balance");
			System.out.println("6. Export statement");
			System.out.println("7. exit");
			
			int choice=sc.nextInt();
			switch (choice){
			case 1:
			System.out.println("enter the account number and amount to deposit");
			sc.nextLine();
			String accno=sc.nextLine();
			double amount=sc.nextDouble();
			txn.deposit(accno,amount);
			System.out.println("amount deposited successfully");
			System.out.println(expserv.exportStatementasCSV(accno));
			break;
			case 2:
			System.out.println("enter founds transfer details");
			System.out.println("enter the from account");
			String accno1=sc.next();
			sc.nextLine();
			System.out.println("enter the to account");
			String accno2=sc.next();
			sc.nextLine();
			System.out.println("enter the amount to transfer");
			double amount1=sc.nextDouble();
			sc.nextLine();
			txn.transfer(accno1,accno2,amount1);
			System.out.println("trnsaction successfully");
			System.out.println(expserv.exportStatementasCSV(accno1));
			System.out.println(expserv.exportStatementasCSV(accno2));
			break;
			case 3:
			intserv.applyAnnualInterest();
			break;
			case 4:
			System.out.println("enter the account number");
			String accno5=sc.next();
			sc.nextLine();
			System.out.println("enter amount for withdrawal");
			double amount4=sc.nextDouble();
			txn.withdraw(accno5, amount4);
			System.out.println("withdrawal successfully");
			System.out.println(expserv.exportStatementasCSV(accno5));
			break;
			case 5:
			System.out.println("enter the account number");
			String acc=sc.next();
			sc.nextLine();
			System.out.printf("Current Balance: %.2f\n", txn.getBalance(acc));
			break;
			case 6:
			System.out.println("enter the account number");
			String acc1=sc.next();
			sc.nextLine();
			System.out.println("your statement ready to view");
			System.out.println("----Account Statements (CSV)-----");
			String csv=expserv.exportStatementasCSV(acc1);
			System.out.println(csv);
			break;
			case 7:
			running = false;
			System.out.println("Exiting System. Goodbye!");
			System.out.println("thanks for using.....");
			System.out.println("Have a wonderful rest of your day........");
			break;
			default:
			System.out.println("invalid entry");
			break;
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();	
	}

}
