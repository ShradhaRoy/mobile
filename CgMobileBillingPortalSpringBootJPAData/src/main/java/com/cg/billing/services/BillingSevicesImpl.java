package com.cg.billing.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.billing.daoservices.BillDAO;
import com.cg.billing.daoservices.CustomerDAO;
import com.cg.billing.daoservices.PlanDAO;
import com.cg.billing.daoservices.PostpaidAccountDAO;
import com.cg.billing.exceptions.BillDetailsNotFoundException;
import com.cg.billing.exceptions.CustomerDetailsNotFoundException;
import com.cg.billing.exceptions.InvalidBillMonthException;
import com.cg.billing.exceptions.PlanDetailsNotFoundException;
import com.cg.billing.exceptions.PostpaidAccountNotFoundException;
import com.cg.billing.beans.*;
@Component("billingServices")
public class BillingSevicesImpl implements BillingServices{
	@Autowired
	private CustomerDAO custdata;
	@Autowired
	private BillDAO billdata;
	@Autowired
	private static PlanDAO plandata;
	@Autowired
	private PostpaidAccountDAO accountdata;

	@Override
	public List<Plan> getPlanAllDetails() {
		
		return plandata.findAll();
	}

	@Override
	public Customer acceptCustomerDetails(Customer customer) {	 
		customer=custdata.save(customer);
		return customer;
	}

	@Override
	public long openPostpaidMobileAccount(int customerID, int planID)
			throws PlanDetailsNotFoundException, CustomerDetailsNotFoundException {
		PostpaidAccount account=new PostpaidAccount(customerID, planID);
		account=accountdata.save(account);
		return account.getMobileNo();
	}

	@Override
	public double generateMonthlyMobileBill(int customerID, long mobileNo, String billMonth, int noOfLocalSMS,
			int noOfStdSMS, int noOfLocalCalls, int noOfStdCalls, int internetDataUsageUnits)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, InvalidBillMonthException, PlanDetailsNotFoundException {
		Plan plan=getCustomerPostPaidAccountPlanDetails(customerID, mobileNo);
		PostpaidAccount account=getPostPaidAccountDetails(customerID, mobileNo);
		double VoiceCallBill=0;
		double SMSBill=0;
		double StdSMSBill=0;
		double StdVoiceBill=0;
		double Internetbill=0;
		double CGST=0;
		double SGST=0;
		if(noOfLocalCalls>plan.getFreeLocalCalls()) {
			VoiceCallBill = (noOfLocalCalls-plan.getFreeLocalCalls())*plan.getLocalCallRate();
		}
		if(noOfLocalSMS>plan.getFreeLocalSMS()) {
		SMSBill=(noOfLocalSMS-plan.getFreeLocalSMS())*plan.getLocalSMSRate();
		}
		if(noOfStdCalls>plan.getFreeStdSMS()) {
	    StdSMSBill=(noOfStdSMS-plan.getFreeStdSMS())*plan.getStdSMSRate();
		}
		if(noOfStdCalls>plan.getFreeStdCalls()) {
		StdVoiceBill=(noOfStdCalls-plan.getFreeStdCalls())*plan.getStdCallRate();
		}
		if(internetDataUsageUnits>plan.getInternetDataUsageRate()) {
	    Internetbill=(internetDataUsageUnits-plan.getFreeInternetDataUsageUnits())*plan.getInternetDataUsageRate();
		}
		double Bill=VoiceCallBill+SMSBill+StdSMSBill+StdVoiceBill+Internetbill;
		CGST=Bill*.09;
		SGST=Bill*.09;
		double TotalBill=Bill+CGST+SGST;
		return TotalBill;
	}

	@Override
	public Customer getCustomerDetails(int customerID) throws CustomerDetailsNotFoundException {
		
		return custdata.findById(customerID).orElseThrow(()->new CustomerDetailsNotFoundException("Customer Not Found"));
	}

	@Override
	public List<Customer> getAllCustomerDetails() {
		
		return custdata.findAll();
	}

	@Override
	public PostpaidAccount getPostPaidAccountDetails(int customerID, long mobileNo)throws PostpaidAccountNotFoundException{
	
	return accountdata.findById(mobileNo).orElseThrow(()->new PostpaidAccountNotFoundException("AccounNotFound"));
	}
	@Override
	public List<PostpaidAccount> getCustomerAllPostpaidAccountsDetails(int customerID)
			throws CustomerDetailsNotFoundException {
		
		return accountdata.findAll();
	}

	@Override
	public boolean getMobileBillDetails(int customerID, long mobileNo, String billMonth)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, InvalidBillMonthException,
			BillDetailsNotFoundException {
		if(billMonth.equalsIgnoreCase("January")||billMonth.equalsIgnoreCase("February")||billMonth.equalsIgnoreCase("March")||billMonth.equalsIgnoreCase("April")||billMonth.equalsIgnoreCase("May")||billMonth.equalsIgnoreCase("June")||billMonth.equalsIgnoreCase("July")||billMonth.equalsIgnoreCase("August")||billMonth.equalsIgnoreCase("September")||billMonth.equalsIgnoreCase("October")||billMonth.equalsIgnoreCase("November")||billMonth.equalsIgnoreCase("December"));
		
		else
		throw new InvalidBillMonthException();
		return true;
	}

	@Override
	public List<Bill> getCustomerPostPaidAccountAllBillDetails(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException {
		
		return billdata.findAll();
	}

	@Override
	public boolean changePlan(int customerID, long mobileNo, int planID)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException,PlanDetailsNotFoundException {
		PostpaidAccount account=new PostpaidAccount();
		Plan plan=((PostpaidAccount) accountdata).getPlan();
		if(plan==null)
			throw new PlanDetailsNotFoundException("No plan found");
		account.setPlan(plan);
		accountdata.save(account);
		return true;
	}

	@Override
	public boolean closeCustomerPostPaidAccount(int customerID, long mobileNo) throws PostpaidAccountNotFoundException{
			accountdata.delete(getPostPaidAccountDetails(customerID, mobileNo));
		return true;
	}

	@Override
	public boolean removeCustomerDetails(int customerID) throws CustomerDetailsNotFoundException {
		custdata.delete(getCustomerDetails(customerID));
		return true;
	}

	@Override
	public Plan getCustomerPostPaidAccountPlanDetails(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, PlanDetailsNotFoundException {
		PostpaidAccount account=new PostpaidAccount();
		Plan plan=account.getPlan();
		if(plan==null)
			throw new PlanDetailsNotFoundException("Plan not found");
		return plan;
	}
	public  static void createPlanDetails()
	{
		plandata.save(new Plan(501,100,200,100,3000,1000,2,1.0f,2.0f,1.5f,2.5f,50.0f,"Hinjewadi","100Rs"));
		plandata.save(new Plan(502,200,300,100,4000,2000,3,0.5f,2.0f,1.0f,1.5f,40.0f,"Phase3","200Rs"));
		plandata.save(new Plan(503,300,400,100,3000,1000,2,1.5f,2.0f,1.0f,2.5f,50.0f,"Balewadi","300Rs"));
		plandata.save(new Plan(504,400,500,100,4000,2000,3,0.5f,1.0f,1.5f,1.5f,30.0f,"SQS","400Rs"));
	}

}
