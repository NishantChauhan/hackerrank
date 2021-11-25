package hackerrank.warmup;

import java.util.stream.IntStream;

public class Staircase {
	public static void main(String[] args) {
		IntStream.rangeClosed(1, 6).map(i->7-i).forEach(row -> {
			IntStream.rangeClosed(1, 6).forEach(column -> {
				if(row<=column) {
					System.out.print("#");
				}
				else {
					System.out.print(" ");
				}
			});
			System.out.println();
		});

	}
}
