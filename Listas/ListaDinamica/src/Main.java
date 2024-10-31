
public class Main {

	public static void main(String[] args) {

		ListaDinamica listaAvioes = new ListaDinamica();
		
		listaAvioes.adicionar(new Aero("Proprietario 1",500));
		listaAvioes.adicionar(new Aero("Proprietario 2",550));
		listaAvioes.adicionar(new Aero("Proprietario 3",560));
		
		System.out.println("Lista de avioes: ");
		listaAvioes.listar();
		
	}

}

class Aero {
	private String proprietario;
	private int speed;

	public Aero(String proprietario, int speed) {
		super();
		this.proprietario = proprietario;
		this.speed = speed;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {// O método toString é utilizado para exibir a representação textual de um
								// objeto
		return "Aviao:  {" + "proprietario='" + proprietario + '\'' + ",speed " + speed + "}";
		/*
		 * Atalho alt+shift+s , clicar em override, nele terão alguns métodos para serem
		 * criados
		 */
	}

}// Classe interna para representar o nó da lista

class ListaDinamica {
    private No inicio;
    private int tamanho;

    private class No {
        Aero dado;
        No proximo;

        public No(Aero dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    ListaDinamica() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public void adicionar(Aero elemento) {
        No novoNo = new No(elemento);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
        tamanho++;
    }

    public Aero obter(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        No atual = inicio;
        for (int i = 0; i < indice; i++) {
            atual = atual.proximo;
        }
        return atual.dado;
    }

    public void remover(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        if (index == 0) {
            inicio = inicio.proximo;
        } else {
            No atual = inicio;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
        }
        tamanho--;
    }

    public void listar() {
        No atual = inicio;
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
    }

    public int tamanho() {
        return tamanho;
    }
}
