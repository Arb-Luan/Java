package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
    	String[] candidatos = {"Felipe", "Marcia", "Julia", "Paulo"};
    	for(String candidato:candidatos)
    	{
    		entrandoEmContato(candidato);
    	
    	
    	}
    	
    
    }
    static void entrandoEmContato(String candidato)
    {
    	int tentativasRealizadas=1;
    	boolean continuarTentando=true;
    	boolean atendeu=false;
    	do 
    	{
    		atendeu=atender();
    		continuarTentando=!atendeu;
    		if(continuarTentando)
    			tentativasRealizadas++;
    		else
    			System.out.println("CONTATO REALIZADO COM SUCESSO!!");
    		//elas precisarão sofrer alterações
    	}while(continuarTentando&&tentativasRealizadas<3);
    	if(atendeu)
    		System.out.println("Conseguimos contato com "+candidato+" na "+tentativasRealizadas+" tentativa ");
    	else
    		System.out.println("Não conseguimos entrar em contato com "+candidato+", numero maximo de tentativas ");
    }
    
    //método auxiliar
    static boolean atender()
    {
    	return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionados() {
    	  String[] candidatos = {"Felipe", "Marcia", "Julia", "Paulo"};
    	  System.out.println("Imprimindo a lista de candidatos informando o índice do elemento");
    	  for(int index=0;index<candidatos.length;index++)
    	  {
    		  System.out.println("O candidato de n"+ index+1+" é "+candidatos[index]);
    	  }
    	  System.out.println("Forma abreviada de interação each");
    	  for(String candidato:candidatos)
    	  {
    		 System.out.println("O candidato selecionado foi "+candidato);
    	  }
    }
    static void analisarCandidato(double salarioPretendido) {
        final double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para candidato com contra proposta");
        } else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirella", "Daniela", "Jorge"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        final double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou este valor de salario: " + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
}
