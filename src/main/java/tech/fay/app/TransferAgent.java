package tech.fay.app;

import java.util.concurrent.ThreadLocalRandom;

public class TransferAgent extends Thread {

	private String name;
	private Account source;
	private Account destination;
	private int amount;

	public TransferAgent(String name, Account source, Account destination, int amount) {
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.amount = amount;
	}

	public void run() {
		try {
			int delay = ThreadLocalRandom.current().nextInt(500, 1500);
			Thread.sleep(delay);
		
			System.out.println(name + " transfering " + this.amount + " between accounts");
			transferFunds(this.source, this.destination, this.amount);
			System.out.println("source balance: " + this.source.getAvailableFunds());
			System.out.println("destination balance: " + this.destination.getAvailableFunds());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void transferFunds(Account source, Account destination, int amount) {
		if (source.getAvailableFunds() >= amount) {
			source.setAvailableFunds(source.getAvailableFunds() - amount);
			destination.setAvailableFunds(destination.getAvailableFunds() + amount);
		} else {
			throw new IllegalArgumentException("Insufficient funds in source: " + source);
		}
	}
}
