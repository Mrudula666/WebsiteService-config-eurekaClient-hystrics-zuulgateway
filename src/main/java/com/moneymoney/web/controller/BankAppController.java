package com.moneymoney.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.moneymoney.web.entity.CurrentDataSet;
import com.moneymoney.web.entity.Transaction;
import com.moneymoney.web.entity.account.Account;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
@EnableHystrix
public class BankAppController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String indexform() {
		return "index";
	}

	/*
	 * @RequestMapping("/home") public String homePage() { return "home"; }
	 */
	/*
	 * @RequestMapping("/login") public String loginForm() { return "login"; }
	 */

	@RequestMapping("/AddAccount")
	public String addNewAccount() {
		return "addAccount";
	}

	@RequestMapping("/OpenAccount")
	@HystrixCommand(fallbackMethod = "addAccountFail")
	public String openAccount(@ModelAttribute Account account, Model model) {
		restTemplate.postForEntity("http://zuul-application/account/accounts/account", account, null);
		model.addAttribute("message", "ACCOUNT CREATED!!");
		return "addAccount";
	}

	public String addAccountFail(@ModelAttribute Account account, Model model) {
		model.addAttribute("message", "unable to add account");
		return "addAccount";
	}

	@RequestMapping("/deposit")
	public String depositForm() {
		return "DepositForm";
	}

	@RequestMapping("/withdraw")
	public String withdrawForm() {
		return "withdraw";
	}

	@RequestMapping("/transferfund")
	public String fundTransferForm() {
		return "FundTransfer";
	}

	@RequestMapping("/depositForm")
	@HystrixCommand(fallbackMethod = "depositFail")
	public String deposit(@ModelAttribute Transaction transaction, Model model) {
		System.out.println("Redirecting to transaction");
		restTemplate.postForEntity("http://zuul-application/transaction/transactions/deposit", transaction, null);
		System.out.println("trasaction");
		model.addAttribute("message", "Success!");
		return "DepositForm";
	}

	public String depositFail(@ModelAttribute Transaction transaction, Model model) {
		model.addAttribute("message", "Unable to deposit");
		return "DepositForm";
	}

	@RequestMapping("/WithdrawForm")
	@HystrixCommand(fallbackMethod = "withdrawFail")
	public String withdraw(@ModelAttribute Transaction transaction, Model model) {
		System.out.println("Redirecting to transaction");
		System.out.println(transaction);
		restTemplate.postForEntity("http://zuul-application/transaction/transactions/withdraw", transaction, null);

		model.addAttribute("message", "Success!");
		return "withdraw";
	}

	public String withdrawFail(@ModelAttribute Transaction transaction, Model model) {
		model.addAttribute("message", "Unable to connect");
		return "withdraw";
	}

	@RequestMapping("/fundTransferForm")
	@HystrixCommand(fallbackMethod = "fundTransferFail")
	public String fundTransfer(@RequestParam("senderAccountNumber") int senderAccountNumber,
			@RequestParam("receiverAccountNumber") int receiverAccountNumber, @RequestParam("amount") double amount,
			@ModelAttribute Transaction transaction, Model model) {
		transaction.setAccountNumber(senderAccountNumber);
		restTemplate.postForEntity("http://zuul-application/transaction/transactions/withdraw", transaction, null);
		transaction.setAccountNumber(receiverAccountNumber);
		restTemplate.postForEntity("http://zuul-application/transaction/transactions/deposit", transaction, null);
		model.addAttribute("message", "Transfer Success!");
		return "FundTransfer";
	}

	public String fundTransferFail(@RequestParam("senderAccountNumber") int senderAccountNumber,
			@RequestParam("receiverAccountNumber") int receiverAccountNumber, @RequestParam("amount") double amount,
			@ModelAttribute Transaction transaction, Model model) {
		model.addAttribute("message", "Unable to connect");
		return "FundTransfer";
	}

	@RequestMapping("/getAllThestatements")
	public String getStatement() {
		return "getStatements";
	}

	@RequestMapping("/getAllTheStatements")
	@HystrixCommand(defaultFallback = "getStatementFail")
	public ModelAndView getStatements(@RequestParam("offset") int offset, @RequestParam("size") int size) {
		int currentOffSet = offset == 0 ? 1 : offset;
		int currentSize = size == 0 ? 5 : size;
		Link previous = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(BankAppController.class)
				.getStatements(currentOffSet - currentSize, currentSize)).withRel("previous");
		Link next = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(BankAppController.class)
				.getStatements(currentOffSet + currentSize, currentSize)).withRel("next");
		CurrentDataSet currentDataSet = restTemplate.getForObject("http://zuul-application/transaction/transactions",
				CurrentDataSet.class);
		List<Transaction> transactionList = currentDataSet.getTransactions();
		List<Transaction> transactions = new ArrayList<Transaction>();
		for (int value = currentOffSet - 1; value < currentOffSet + currentSize - 1; value++) {
			if ((transactionList.size() <= value) || currentOffSet < 1)
				break;
			System.out.println(value);
			Transaction transaction = transactionList.get(value);
			transactions.add(transaction);
		}
		currentDataSet.setPreviousLink(previous);
		currentDataSet.setNextLink(next);
		currentDataSet.setTransactions(transactions);
		return new ModelAndView("getStatements", "currentDataSet", currentDataSet);

	}

	public ModelAndView getStatementFail() {

		return new ModelAndView("getStatements", "message", "Unable to connect");

	}

}
