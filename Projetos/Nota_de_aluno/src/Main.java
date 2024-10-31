import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Usando MyIO
		/*System.out.println("Inserir a nota do aluno");
		int nota=MyIO.readInt();
		if(nota>=80)
			System.out.println("Parabéns, muito bom!");
		else if(nota>=70&&nota<80)
			System.out.println("Parabéns!Aprovado");
		else
			System.out.println("Infelizmente reprrovado");
*/
		Scanner myScanner=new Scanner(System.in);
		int nota;
		System.out.println("Inserir nota");
		nota=myScanner.nextInt();
		if(nota>=80)
			System.out.println("Parabéns, muito bom!");
		else if(nota>=70&&nota<80)
			System.out.println("Parabéns!Aprovado");
		else
			System.out.println("Infelizmente reprovado");
		
	}
	
}
