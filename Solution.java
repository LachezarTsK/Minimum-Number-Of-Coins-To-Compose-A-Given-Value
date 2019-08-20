import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	private static int numberOfCoinValues;
	private static int targetValue;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		numberOfCoinValues = scanner.nextInt();
		targetValue = scanner.nextInt();

		int[] coinValues = new int[numberOfCoinValues];
		for (int i = 0; i < numberOfCoinValues; i++) {
			coinValues[i] = scanner.nextInt();
		}
		scanner.close();

		int result = minimumCoinsToComposeTargetValue(coinValues);
		System.out.println(result);
	}

	private static int minimumCoinsToComposeTargetValue(int[] coinValues) {

		int[] minimumCoins = new int[targetValue + 1];
		Arrays.fill(minimumCoins, Integer.MAX_VALUE);
		Arrays.sort(coinValues);
		minimumCoins[0] = 0;

		for (int subValue = 1; subValue <= targetValue; subValue++) {
			for (int i = 0; i < numberOfCoinValues && coinValues[i] <= subValue; i++) {

				if (minimumCoins[subValue - coinValues[i]] != Integer.MAX_VALUE) {
					if (minimumCoins[subValue - coinValues[i]] + 1 < minimumCoins[subValue]) {
						minimumCoins[subValue] = minimumCoins[subValue - coinValues[i]] + 1;
					}
				}
			}
		}
		return minimumCoins[targetValue];
	}
}
