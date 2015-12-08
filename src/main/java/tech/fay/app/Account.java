package tech.fay.app;

public class Account {
	private long id;
	public long getId() {
		return this.id;
	}
	
	private int availableFunds;
	public synchronized int getAvailableFunds() {
		return this.availableFunds;
	}
	public synchronized void setAvailableFunds(int funds) {
		this.availableFunds = funds;
	}
}
