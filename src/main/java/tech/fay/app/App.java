package tech.fay.app;

public class App {
    public static void main(String[] args) {
		// TODO: run the transfer funds code with multiple threads

		Account alice = new Account();
		alice.setAvailableFunds(1000);
		Account bob = new Account();
		bob.setAvailableFunds(1000);

		for (int i = 0; i < 10; i++) {
			TransferAgent eve = new TransferAgent("eve", alice, bob, 50);
			TransferAgent frank = new TransferAgent("frank", alice, bob, 100);

			eve.start();
			frank.start();
		}
    }
}
