import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
	ListaEstatica avioes=new ListaEstatica(3);//Criação de uma lista de objetos;
	avioes.preencherLista();
	avioes.listar();
	avioes.pesquisa();
	}

}
class Aero
{
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
	public String toString() {//O método toString é utilizado para exibir a representação textual de um objeto
		return "Aviao:  {"+"proprietario='"+proprietario+'\''+",speed"+speed+"}";
	/*Atalho alt+shift+s , clicar em override, nele terão alguns métodos para serem criados*/
	}
	
	
}
class ListaEstatica {
    private Aero	[]	 lista;
    private int tamanhoAtual;

    public ListaEstatica(int capacidade) {
        lista = new Aero[capacidade];
        tamanhoAtual = 0;
    }

    public boolean adicionar(Aero elemento) {
        if (tamanhoAtual < lista.length) {
            lista[tamanhoAtual++] = elemento;
            return true;
        } else {
            System.out.println("Lista está cheia!");
            return false;
        }
    }

    public Aero obter(int indice) {
        if (indice >= 0 && indice < tamanhoAtual) {
            return lista[indice];
        } else {
            throw new ArrayIndexOutOfBoundsException("Índice inválido!");
        }
    }
    
    public void preencherLista()//Preenche lista
    {
    	Scanner scan=new Scanner(System.in);//Apenas uma instancia de scanner é precisa
    	for(int i=0;i<lista.length;i++)
    	{
    		System.out.println("Inserir proprietario");
    		String proprietario=scan.nextLine();
    		System.out.println("Inserir velocidade");
    		int speed=scan.nextInt();
    		Aero aviao=new Aero(proprietario,speed);//Cria objeto
    		adicionar(aviao);//Executa metodo de adicionar objeto a lista
    		scan.nextLine();//consome nova linha pendente
    	}
    	//scan.close();
    	/*Ao fechar um objeto da classe scanner, todos são fechados+
    	 * */
    }
    

    public int tamanho() {
        return tamanhoAtual;
    }
    public void listar()
    {
    	for(int i=0;i<tamanhoAtual;i++)
    	{
    		System.out.println(lista[i]);
    	}
    }
    public void pesquisa()
    {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Inserir indice que quer procurar");
    	int index = scan.nextInt();
    	try
    	{
    		Aero aviaoPesquisa=obter(index);
    		System.out.println("Aviao especifico"+aviaoPesquisa);
    	}
    	catch(ArrayIndexOutOfBoundsException e)
    	{
    		System.out.println(e.getMessage());
    	}
    }
}
