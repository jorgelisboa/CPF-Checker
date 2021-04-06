import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

public class CPFVerify {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Variáveis da verificação
		int soma1 = 0;
		int soma2 = 0;
		
		//Variaveis da execução
		String CPF = "346.567.568-14"; //Array do CPF
		CPF = CPF.replaceAll("[-.]", ""); //Tirando o que não quero da string
		int[] numerosCPF = new int[11]; //Criando array onde guardo cada carctere
		
		//Adicionando valores na array
		for (int i = 0; i < CPF.length(); i++){
			int selecionador = Character.getNumericValue(CPF.charAt(i));
			numerosCPF[i] = selecionador;
		}
		//Fazendo 1° conta
		
		for (int i = 0 , ValSoma1 = 10; i < numerosCPF.length && ValSoma1 >= 2; i++,ValSoma1--) {
			int x =  numerosCPF[i] * ValSoma1;
			soma1 += x;
		}
		System.out.println("A primeira soma deu: "+soma1);
		
		//Fazendo 2° conta
		for (int i = 0 , ValSoma2 = 11; i < numerosCPF.length && ValSoma2 >= 2; i++ , ValSoma2--) {
			int x= (numerosCPF[i] * ValSoma2);
			soma2 += x;
		}
		System.out.println("A segunda soma deu: "+soma2);
		System.out.println("-----------------");
		//Digitos verificadores
		int digito1 = soma1*10%11;
		int digito2 = soma2*10%11;
		
		//Saídas
		System.out.println("O prmiero dígito verificador deve ser: "+digito1);
		System.out.println("O segundo dígito verificador deve ser: "+digito2);
		System.out.println("O prmiero dígito verificador é: "+numerosCPF[9]);
		System.out.println("O segundo dígito verificador é: "+numerosCPF[10]);
		//MUDANDO PRA COMPARAR COM OS DIGITOS
		if(digito1 == numerosCPF[9] && digito2 == numerosCPF[10]) {
			System.out.println("CPF Válido");
			System.out.println("-----------------");
		}else if(digito1 != numerosCPF[9] && digito2 != numerosCPF[10]) {
			System.out.println("CPF Inválido");
			System.out.println("-----------------");
		}else if(CPF.equals("00000000000")|| CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999")) {
			
			System.out.println("CPF Inválido");
			System.out.println("-----------------");
        }
	}
}