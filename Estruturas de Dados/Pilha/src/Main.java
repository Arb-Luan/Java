import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// Criar uma lista de elementos inteiros
		Pilha pilhaInteiros = new Pilha();
		PilhaAux p = new PilhaAux();
		p.inserirElementos(pilhaInteiros, 3);
		pilhaInteiros.show();
	}

}
//Classe auxiliar que 
class PilhaAux{
		Scanner scan = new Scanner(System.in);
		public PilhaAux()//Construtor da classe auxiliar
		{}
		void inserirElementos(Pilha pilha,int x)//Método que insere x elementos numa lista
		{
			int elemento;
			System.out.println("Preenchimento de uma fila com "+ x +" elementos: ");		
			for(int i=0;i<x;i++)
			{
				elemento=scan.nextInt();
				pilha.add(elemento);
			}
			
		}		
		
	
}

class Pilha {

	Cell top;

	public Pilha()// construtor da pilha
	{
		top = null;// A pinha começa com nada
	}

	private class Cell {// Para implementação de uma pilha é necessário criar uma célula;
		int elemento;
		Cell next;

		Cell(int elemento) {
			this.elemento = elemento;
			this.next = null;

		}
	}

	// Método para inserir elemento na pilha
	public void add(int x) {
		Cell tmp = new Cell(x);
		tmp.next = top;// A celula criada vira o topo da pilha
		top = tmp;
		tmp = null;
	}

	// Método para remover elemento da pilha
	public int remove() throws Exception {
		if (top == null)
			throw new Exception("Erro");
		int elemento = top.elemento;
		Cell tmp = top;
		top = top.next;
		tmp.next = null;
		tmp = null;
		return elemento;
	}

	// Método para mostrar os elementos da pilha
	public void show() {
		System.out.println("[");
		for (Cell i = top; i != null; i = i.next) {
			System.out.println(i.elemento + " ");
		}
		System.out.println("]");
	}
}
