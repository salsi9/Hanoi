package hanoi;
import java.util.Scanner;

import hanoi.formulation.HanoiEnvironment;

public class Ejecutable {

	public static void main(String[]arg){
		Scanner in=new Scanner(System.in);
		int nStick, nPiece;
		System.out.println("How many towers: ");
		nStick=in.nextInt();
		System.out.println("How many pieces: ");
		nPiece=in.nextInt();
		HanoiEnvironment newEnv=new HanoiEnvironment(nStick,nPiece);
		System.out.println(newEnv);
	}
}
