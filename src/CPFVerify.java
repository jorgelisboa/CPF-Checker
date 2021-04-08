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
		//MY CODE WAS LIKE THIS IN ANDROID STUDIO//
		/*
		//Tirando a máscara do CPF
        if (CPF_cd.getText().toString().length() == 14) {
            String newcpf;
            newcpf = CPF_cd.getText().toString().replaceAll("[-.]", ""); //4 8 6 5 7 5 1 8 3 2
            int num1;
            int num2;
            int num3;
            int num4;
            int num5;
            int num6;
            int num7;
            int num8;
            int num9;
            int num10;
            int num11;

            //CONVERSÕES PRA NÃO PEGAR A TABELA ASCII
            num1 = Character.getNumericValue(newcpf.charAt(0));
            num2 = Character.getNumericValue(newcpf.charAt(1));
            num3 = Character.getNumericValue(newcpf.charAt(2));
            num4 = Character.getNumericValue(newcpf.charAt(3));
            num5 = Character.getNumericValue(newcpf.charAt(4));
            num6 = Character.getNumericValue(newcpf.charAt(5));
            num7 = Character.getNumericValue(newcpf.charAt(6));
            num8 = Character.getNumericValue(newcpf.charAt(7));
            num9 = Character.getNumericValue(newcpf.charAt(8));
            num10 = Character.getNumericValue(newcpf.charAt(9));
            num11 = Character.getNumericValue(newcpf.charAt(10));
            int valor;
            int valor2;

            //Verificação 1
            int x = (num1 * 10) + (num2 * 9) + (num3 * 8) + (num4 * 7) + (num5 * 6) + (num6 * 5) + (num7 * 4) + (num8 * 3) + (num9 * 2);
            int resto = x % 11;
            //DIGITOS DE VERIFICAÇÃO
                if (resto < 2) {
                    valor = 0;
                } else {
                    valor = 11 - resto;
                }
            //Verificação 2
            int y = (num1 * 11) + (num2 * 10) + (num3 * 9) + (num4 * 8) + (num5 * 7) + (num6 * 6) + (num7 * 5) + (num8 * 4) + (num9 * 3) + (num10 * 2);
            int restoDois = y % 11;
            //DIGITOS DE VERIFICAÇÃO
                if (restoDois < 2) {
                    valor2 = 0;
                } else {
                    valor2 = 11 - restoDois;
                }
                //Limpando campos
                if (valor != num10 && valor2 != num11) {
                    Toast.makeText(this, "CPF inválido", Toast.LENGTH_SHORT).show();
                    CPF_cd.setText("");
                }
		*/
	}
}
