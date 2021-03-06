package lukasz.controller;

import java.util.Random;

public class Test {
	static boolean isAlive = false;
	public static final int SEKUNDY = 5;
	static Random rand = new Random();
	public static void main(String[] args) {
		MaestroController controller = null;

		try {
			controller = new MaestroController("COM5", true);
			isAlive = true;
			Thread.sleep(1000);
			System.out.println("Let's play!");
			int channel = 0;
			while (isAlive) {
				blink(controller, channel);
			}

			controller.goHome();
			controller.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void blink(MaestroController controller, int channel)
			throws InterruptedException {
		controller.setPosition(channel, 600);
		Thread.sleep(100);
		controller.setPosition(channel, 2000);
		long milis = (long) (100+ rand.nextFloat()*1000*SEKUNDY);
		Thread.sleep(milis);
		System.out.println("\nMrugam: "+ milis/1000+" s\n");
		
	}
}
