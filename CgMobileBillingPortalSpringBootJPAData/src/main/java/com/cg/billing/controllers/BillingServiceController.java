package com.cg.billing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.billing.beans.Customer;
import com.cg.billing.beans.Plan;
import com.cg.billing.exceptions.CustomerDetailsNotFoundException;
import com.cg.billing.exceptions.InvalidBillMonthException;
import com.cg.billing.exceptions.PlanDetailsNotFoundException;
import com.cg.billing.exceptions.PostpaidAccountNotFoundException;
import com.cg.billing.services.BillingServices;

@Controller
public class BillingServiceController {

	@Autowired
	BillingServices services;
	@RequestMapping("/registerCustomer")
	public ModelAndView registerCustomer(@ModelAttribute Customer customer) {
		customer = services.acceptCustomerDetails(customer);
		return new ModelAndView("registrationPage","customer",customer);
	}
	@RequestMapping("/customerDetails")
	public ModelAndView getCustomerDetails(@RequestParam int customerID) throws CustomerDetailsNotFoundException {
	Customer customer = services.getCustomerDetails(customerID);
		return new ModelAndView("findCustomerDetailsPage","customer",customer);
	}
	@RequestMapping("/postpaid")
	public ModelAndView getPostpaidDetails(@RequestParam int customerID,@RequestParam int planID) throws PlanDetailsNotFoundException, CustomerDetailsNotFoundException {
	long account=services.openPostpaidMobileAccount(customerID, planID);
		return new ModelAndView("PostpaidMobileAccount","account",account);
	}
	@RequestMapping("/PlanDetail")
	public ModelAndView getPlanDetails(@RequestParam int planID,@RequestParam int customerID) throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, PlanDetailsNotFoundException{
	Plan plan=services.getCustomerPostPaidAccountPlanDetails(customerID,planID);
		return new ModelAndView("PostpaidMobileAccount","plan",plan);
	}
	@RequestMapping("/monthBill")
	public ModelAndView getMonthlyBillDetails(@RequestParam int customerID, @RequestParam long mobileNo, @RequestParam String billMonth,@RequestParam  int noOfLocalSMS,
			@RequestParam int noOfStdSMS,@RequestParam int noOfLocalCalls,@RequestParam int noOfStdCalls,@RequestParam int internetDataUsageUnits) throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, PlanDetailsNotFoundException, InvalidBillMonthException{
	double bill=services.generateMonthlyMobileBill(customerID, mobileNo, billMonth, noOfLocalSMS, noOfStdSMS, noOfLocalCalls, noOfStdCalls, internetDataUsageUnits);
		return new ModelAndView("MonthlyBillPage","bill",bill);
	}
	@RequestMapping("/remove")
	public ModelAndView getremoveDetails(@RequestParam int customerID) throws CustomerDetailsNotFoundException {
	boolean customer=services.removeCustomerDetails(customerID);
		return new ModelAndView("RemoveDetailsPage","customer",customer);
	}

}
