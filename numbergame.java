import java.util.*;
class guessgame {
	private int atamp = 10;
	private int num1, num2, remark = 0;
	boolean ch = true;

	public void guess() {
		while (ch) {
			num1 = new Random().nextInt(100) + 1;
			while (atamp != 0) {
				System.out.println("Enter your number:");
				Scanner sc = new Scanner(System.in);
				num2 = sc.nextInt();
				if (num2 == num1) {
					System.out.println("Congratulations! You guessed the correct number, the number is:" + num1
							+ "\nYour Score is:" + (remark += atamp));
					break;
				}
				if (num2 < num1) {
					atamp--;
					System.out.println("you guess a low number and you have " + atamp + " chance please try again");
				}
				if (num2 > num1) {
					atamp--;
					System.out.println("you guess a lager number and you have " + atamp + " chance please try again");
				}
			}
			if (atamp == 0) {
				System.out.println("your score is:" + atamp);
			}
			System.out.println("Enter 0 for stop and any key for continue please enter:");
			Scanner sc = new Scanner(System.in);
			int ch1 = sc.nextInt();
			ch = ch1 != 0;
		}
}
}

public class numbergame {
	public static void main(String[] args) {
		guessgame obj = new guessgame();
		obj.guess();
	}
}
