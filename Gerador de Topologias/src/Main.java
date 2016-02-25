import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
		Random random = new Random();
		String quebralinha = System.lineSeparator();
		System.out.println("DIGITE A CAMADA Z");
		Scanner sc = new Scanner(System.in);
		int z = sc.nextInt();
		
		System.out.println("DIGITE A CAMADA X");
		
		int x = sc.nextInt();
		
		System.out.println("DIGITE A CAMADA Y");
		
		int y = sc.nextInt();
		
	
		System.out.println("DIGITE O NUMERO DE ARQUIVOS");

		int n = sc.nextInt();
		String ans = null;
		
		do{
			
		System.out.println("1 - ARQUIVO COM UMA PORCENTAGEM DE ERROS APENAS NA HORIZONTAL SEGUINDO PADRAO DA DIAGONAL?"+quebralinha+"2 - ARQUIVO SEGUINDO O PADRAO DE FALHAS NOS TSVs DO PAPER?"+quebralinha+"3 - ARQUIVOS PUROS?");
		ans = sc.next();
		
		}while((!ans.equalsIgnoreCase("1")) && (!ans.equalsIgnoreCase("2")) && (!ans.equalsIgnoreCase("3")));
		
		
		if(ans.equalsIgnoreCase("1"))
		{
			System.out.println("QUAL PORCENTAGEM?");
			float perc = sc.nextFloat();
			Gerador g = new Gerador(x,y,z,n,perc);
			sc.close();
			g.GerarComPercentSoHorizontalPadraoDiag();
			System.out.println("ARQUIVOS COM ERROS GERADOS COM SUCESSO!");
		}
		
		else if(ans.equalsIgnoreCase("2")){
			ans = null;
			do
			{
				System.out.println("QUAL PORCENTAGEM DE TSVs?"+quebralinha+"a - 25% (um quarto)"+quebralinha+"b - 12,5% (um oitavo)");
				ans = sc.next();
			}while((!ans.equalsIgnoreCase("a")) && (!ans.equalsIgnoreCase("b")));
		
			if(ans.equalsIgnoreCase("a"))
			{
				Gerador g = new Gerador(x,y,z,n,25);
				sc.close();
				g.GerarComPercentApenasDiagSeguindoPadrao();
				System.out.println("ARQUIVOS COM ERROS GERADOS COM SUCESSO!");
				System.out.println(Math.round(4.5));
			}
			else
			{
				Gerador g = new Gerador(x,y,z,n,(float) 12.5);
				sc.close();
				g.GerarComPercentApenasDiagSeguindoPadrao();
				System.out.println("ARQUIVOS COM ERROS GERADOS COM SUCESSO!");
			}
		}

		else{
			Gerador g = new Gerador(x,y,z,n);
			sc.close();
			g.Gerar();
			System.out.println("ARQUIVOS GERADOS COM SUCESSO!");
		}

	}

}


