package dbPayment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import paymentDetails.Payment;

public class PaymentDb {
	public Connection getConnection() {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehiclesparepartdb","root","");
			return con;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	public void insertPayment(Payment po) {
		try{
			Connection con=getConnection();
			Statement st=con.createStatement();
			String query="insert into payment(carholder_name,card_number,expire_date,csv,amount) values('"+po.getName()+"',"+po.getCardNo()+",'"+po.getExpdate()+"',"+po.getCsv()+","+po.getAmount()+");";
			int rs=st.executeUpdate(query);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updatePayment(Payment po) {
		try{
			Connection con=getConnection();
			Statement st=con.createStatement();
			String query="update payment set carholder_name='"+po.getName()+"',card_number="+po.getCardNo()+",expire_date='"+po.getExpdate()+"',csv="+po.getCsv()+",amount="+po.getAmount()+" where payment_id="+po.getId()+";";
			int rs=st.executeUpdate(query);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void deletePayment(String id) {
		try{
			Connection con=getConnection();
			Statement st=con.createStatement();
			String query="delete from payment where payment_id="+id+";";
			int rs=st.executeUpdate(query);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ResultSet selectPendingPayment() {
		try{
			Connection con=getConnection();
			Statement st=con.createStatement();
			String query="select * from payment where status='Pending';";
			ResultSet rs=st.executeQuery(query);
			return rs;
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public ResultSet selectSuccessPayment() {
		try{
			Connection con=getConnection();
			Statement st=con.createStatement();
			String query="select * from payment where status='Success';";
			ResultSet rs=st.executeQuery(query);
			return rs;
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public ResultSet getOnePayment(String id) {
		try{
			Connection con=getConnection();
			Statement st=con.createStatement();
			String query="select * from payment where payment_id="+id+";";
			ResultSet rs=st.executeQuery(query);
			return rs;
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public void updatePaymentStatus(String id) {
		try{
			Connection con=getConnection();
			Statement st=con.createStatement();
			String query="update payment set status='Success' where payment_id="+id+";";
			int rs=st.executeUpdate(query);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
