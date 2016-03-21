package net.nunocraft.LuckyWars;

import java.util.Random;

public class Randomize {
	public static int getRandom (Integer rndcount) {
		
		Random r = new Random();
		int zufall = r.nextInt(rndcount);
		//DEBUG System.out.println(zufall2);
		return zufall;
		
	}
	
}
