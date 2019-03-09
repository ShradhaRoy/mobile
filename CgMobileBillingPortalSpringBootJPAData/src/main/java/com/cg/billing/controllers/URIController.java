package com.cg.billing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cg.billing.beans.Customer;


@Controller
public class URIController {
	
	private Customer customer; 
	@RequestMapping(value={"/","Index"})
	public String getIndexPage() {
		return "IndexPage";	
	}
	@RequestMapping("/registration")
	public String getRegistrationPage(){
		return "registrationPage";	
	}
	@RequestMapping("/findCustomerDetails")
	public String getFindCustomerDetailsPage() {
		return "findCustomerDetailsPage";
	}
	@RequestMapping("/postpaidDetails")
	public String getpostpaidDetailsPage() {
		return "PostpaidMobileAccount";
	}

	@RequestMapping("/planDetails") 
	public String getplanDetailsPage() { 
		return "PlanDetails"; 
	 }
	@RequestMapping("/monthlyBill")
	public String getMonthlyBillPage() {
		return "MonthlyBillPage";
	}
	@RequestMapping("/removeDetails")
	public String getRemoveDetailsPage() {
		return "RemoveDetailsPage";
	}
	

	@ModelAttribute
	public Customer getCustomer() {
		customer=new Customer();
		return customer;	
	}
}
