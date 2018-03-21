import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Gerador {
	int x , y , z,n;
	Random random = new Random();
	int VetX[], VetY[], VetZ[];
	int VetXPuro[],VetYPuro[],VetZPuro[],VetXDig[],VetYDig[],VetZDig[];
	float percentage;
	String path = "C:\\Users\\Gustavo\\Desktop\\POO\\RSBR-3D\\Topologias\\";
	

	
public Gerador (int x , int y , int z,int n){
		this.x = x;
		this.y = y;
		this.z = z;
		this.n = n;
		
}
	
	
public Gerador (int x , int y , int z,int n, float percentage){
	this.x = x;
	this.y = y;
	this.z = z;
	this.n = n;
	VetX = new int[this.z*(this.x-1)*this.y];
	
	for(int a = 0; a < VetX.length; a++)
	{
		VetX[a] = -1;
	}
	
	VetY = new int[this.z*(this.y-1)*this.x];
	
	for(int a = 0; a < VetY.length; a++)
	{
		VetY[a] = -1;
	}
	
	VetZ = new int[(this.z-1)*this.y*this.x];
	
	for(int a = 0; a < VetZ.length; a++)
	{
		VetZ[a] = -1;
	}
	
	this.percentage = percentage;
	
}

//Construtor específico para o método de comparação entre topologias puras e utilizadoras do padrão da diagonal.
public Gerador (int x , int y , int z,int n, float percentage, boolean aux){
	
	this.x = x;
	this.y = y;
	this.z = z;
	this.n = n;
	
	VetXPuro = new int[this.z*(this.x-1)*this.y];
	VetXDig = new int[this.z*(this.x-1)*this.y];
	
	for(int a = 0; a < VetXPuro.length; a++)
	{
		VetXPuro[a] = -1;
		VetXDig[a] = -1;
	}
	
	VetYPuro = new int[this.z*(this.y-1)*this.x];
	VetYDig = new int[this.z*(this.y-1)*this.x];
	
	for(int a = 0; a < VetYPuro.length; a++)
	{
		VetYPuro[a] = -1;
		VetYDig[a] = -1;
	}
	
	VetZPuro = new int[(this.z-1)*this.y*this.x];
	VetZDig = new int[(this.z-1)*this.y*this.x];
	
	for(int a = 0; a < VetZPuro.length; a++)
	{
		VetZPuro[a] = 0;
		VetZDig[a] = -1;
	}
	
	this.percentage = percentage;
	
}




	public void Gerar() throws IOException{
		

			for (int a = 0  ; a < this.n ; a ++){
				File file = new File (path+"Caso - "+z+"X"+x+"X"+y +"("+a+").txt");
				FileWriter esc = new FileWriter(file);
				BufferedWriter bf = new BufferedWriter(esc);
				try {
					/*int l = 0;
					if(z > 2)  l = z*3 -1;
					else if (z ==0) System.err.println("SEM CAMADA Z");
					if (z == 2) l = 5;
					else 	l = 3;
				*/for (int i = 0 ; i < (z*3)-1 ; i++ ){
							
					if(i % 3 == 0){
					
						for(int k = 0 ; k < x ; k++ ){
							for (int p = 0 ; p < x-1 ; p++){
								if(p == 0 && k ==0){
									esc.write("0");//String.valueOf(random.nextInt(2)));	
								
								}else{
								esc.write(" " + "0");// String.valueOf(random.nextInt(2)));
								
								
							}}
							esc.write(";");
							
						}
						
						}
					else
					if(i % 3 == 1){
						
						for(int k = 0 ; k < (y-1) ; k++ ){
							for (int p = 0 ; p < y ; p++) {
							
								if(p == 0 && k == 0){
									esc.write("0");//String.valueOf(0random.nextInt(2)));	
									
								}else{
								esc.write(" " + "0");//String.valueOf(random.nextInt(2)));
								
								}
						}
						
							esc.write(";");
							}}
					
					else
						if(i % 3 == 2){
					
							for(int k = 0 ; k < y ; k++ ){
								for (int p = 0 ; p < x ; p++) {
									if(p == 0 && k == 0){
										esc.write("0");//String.valueOf(random.nextInt(2)));	
									
									}else{
										esc.write(" " + "0");//String.valueOf(random.nextInt(2)));
									
									
								}
								
							}
								
								esc.write(";");


						}
					
					
				}
				
					esc.write("\n");	
				
					
				}	
		
				bf.close();	
				esc.close();
				System.out.println("ARQUIVO  "+(a+1)+" ---->   OK!");
			}
			
		
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
			
			
		
		
	

			}
	
	
	
	
	
	public void GerarComPercentSoHorizontalPadraoDiag() throws IOException{
		
		
		for (int a = 0  ; a < this.n ; a ++){
			
			int erros = 0;
			
			while(erros < ((this.percentage/100)*this.z*(this.x-1)*this.y*2)){		
				
				for (int i = 0 ; i < (z*3)-1 ; i++ ){
				
					if(i % 3 == 0){
						
						for(int k = 0 ; k < this.z*(this.x-1)*this.y ; k++ ){

							int aux = random.nextInt(2);
							if((aux == 1) && (VetX[k] != 1)){
								if(erros < ((this.percentage/100)*this.z*(this.x-1)*this.y*2))
								{
									VetX[k] = aux;
									erros++;
								}
							}
							else if(VetX[k] == -1)
							{
								VetX[k] = aux;
							}
						}
					}
					
					else if(i % 3 == 1){
					
						for(int k = 0 ; k < this.z*this.x*(this.y-1) ; k++ ){
						
							
								int aux = random.nextInt(2);
								if((aux == 1) && (VetY[k] != 1)){
									if(erros < ((this.percentage/100)*this.z*(this.x-1)*this.y*2))
									{
										VetY[k] = aux;
										erros++;
									}
								}
								else if((aux == 0) && (VetY[k] == -1))
								{
									VetY[k] = aux;
								}
						}
					
							}
				
					else if(i % 3 == 2){
				
							for(int j = 0; j < (this.z-1); j++){
								for(int p = 0; p < this.x*this.y; p++){
								
									if(p % (this.x+1) == 0)
									{
										VetZ[(j*this.x*this.y)+p] = 0;
									}
								
									else
									{
										VetZ[(j*this.x*this.y)+p] = 1;
									}
								}
							}
					}
				}
			}
			
			
		for(int i = 0; i < VetX.length; i++){
				
			if(VetX[i] == -1)
			{
				VetX[i] = 0;
			}
		}
		
		for(int i = 0; i < VetY.length; i++){
			
			if(VetY[i] == -1)
			{
				VetY[i] = 0;
			}
		}
		
		for(int i = 0; i < VetZ.length; i++){
			
			if(VetZ[i] == -1)
			{
				VetZ[i] = 0;
			}
		}
			

	System.out.println(erros);
	System.out.println((this.percentage/100)*this.z*(this.x-1)*this.y*2);

			
	for(int i = 0; i < VetX.length; i++){
		
			System.out.print(VetX[i]+"\t");
			
	}
	System.out.println("");
	for(int i = 0; i < VetY.length; i++){
		
		System.out.print(VetY[i]+"\t");
		
	}
	System.out.println("");
	for(int i = 0; i < VetZ.length; i++){
		
		System.out.print(VetZ[i]+"\t");
		
	}
	System.out.println("");
			
			
			File file = new File (path+"Caso - "+z+"X"+x+"X"+y +"("+a+").txt");
			FileWriter esc = new FileWriter(file);
			BufferedWriter bf = new BufferedWriter(esc);
			try {
				/*int l = 0;
				if(z > 2)  l = z*3 -1;
				else if (z ==0) System.err.println("SEM CAMADA Z");
				if (z == 2) l = 5;
				else 	l = 3;
			*/for (int i = 0 ; i < (z*3)-1 ; i++ ){
						
				if(i % 3 == 0){
				
					for(int k = 0 ; k < x ; k++ ){
						for (int p = 0 ; p < x-1 ; p++){
							if(p == 0 && k ==0){
								esc.write(String.valueOf(VetX[((i/3)*(this.x-1)*this.y)+(k*(this.x-1))+p]));	
							
							}else{
							esc.write(" " + String.valueOf(VetX[((i/3)*(this.x-1)*this.y)+(k*(this.x-1))+p]));
							
							
						}}
						esc.write(";");
						
					}
					
					}
				else
				if(i % 3 == 1){
					
					for(int k = 0 ; k < (y-1) ; k++ ){
						for (int p = 0 ; p < y ; p++) {
						
							if(p == 0 && k == 0){
								esc.write(String.valueOf(VetY[(((i-1)/3)*this.x*(this.y-1))+(k*this.y)+p]));	
								
							}else{
								esc.write(" " + String.valueOf(VetY[(((i-1)/3)*this.x*(this.y-1))+(k*this.y)+p]));
							
							}
					}
					
						esc.write(";");
						}}
				
				else
					if(i % 3 == 2){
				
						for(int k = 0 ; k < y ; k++ ){
							for (int p = 0 ; p < x ; p++) {
								if(p == 0 && k == 0){
									esc.write(String.valueOf(VetZ[(k*this.x)+p]));	
								
								}else{
									esc.write(" " + String.valueOf(VetZ[(k*this.x)+p]));
								
								
							}
							
						}
							
							esc.write(";");


					}
				
				
			}
			
				esc.write("\n");	
			
				
			}	
	
			bf.close();	
			esc.close();
			System.out.println("ARQUIVO  "+(a+1)+" ---->   OK!");
			
			
			for(int i = 0; i < VetX.length; i++){

					VetX[i] = -1;
			}
			
			for(int i = 0; i < VetY.length; i++){
				
					VetY[i] = -1;
			}
			
			for(int i = 0; i < VetZ.length; i++){
				
					VetZ[i] = -1;
			}
			
		}
		
	
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
		
	
	


		}

	
public void GerarComPercentApenasDiagSeguindoPadrao() throws IOException{
		
	for (int a = 0  ; a < this.n ; a ++){
		
		int TSVs = 0;
		
		while(TSVs < Math.round(((this.percentage/100)*(this.z-1)*this.x*this.y))){		
		
			for (int i = 0 ; i < (z*3)-1 ; i++ ){
			
				if(i % 3 == 0){
					
					for(int k = 0 ; k < this.z*(this.x-1)*this.y; k++){
						
								VetX[k] = 0;
							}
						}
					
				else if(i % 3 == 1){
				
					for(int k = 0 ; k < this.z*this.x*(this.y-1) ; k++ ){
					
									VetY[k] = 0;
								}
							}
			
				else if(i % 3 == 2){
			
						for(int j = 0; j < (this.z-1); j++){
							for(int p = 0; p < this.x*this.y; p++){
							
								int aux = random.nextInt(2);
								if((aux == 0) && (VetZ[(j*this.x*this.y)+p] != 0))
								{
									if(p % (this.x+1) == 0)
									{
										if(TSVs < Math.round(((this.percentage/100)*(this.z-1)*this.x*this.y))){
											VetZ[(j*this.x*this.y)+p] = aux;
											TSVs++;
										}
									}
							
									else
									{
										VetZ[(j*this.x*this.y)+p] = 1;
									}
								}
							}
						}
						if(TSVs == (this.z-1)*this.x)
						{
							while(TSVs < Math.round(((this.percentage/100)*(this.z-1)*this.x*this.y))){
							int aux2 = random.nextInt(((this.z-1)*this.x*this.y));
							if(VetZ[aux2] != 0)
							{
								int aux3 = random.nextInt(2);
								if(aux3 == 0)
								{
									if(TSVs < Math.round(((this.percentage/100)*(this.z-1)*this.x*this.y)))
									{
										VetZ[aux2] = aux3;
										TSVs++;
									}
								}
							}
							}
						}
				}
			}
		}
		
		
	for(int i = 0; i < VetX.length; i++){
			
		if(VetX[i] == -1)
		{
			VetX[i] = 0;
		}
	}
	
	for(int i = 0; i < VetY.length; i++){
		
		if(VetY[i] == -1)
		{
			VetY[i] = 0;
		}
	}
	
	for(int i = 0; i < VetZ.length; i++){
		
		if(VetZ[i] == -1)
		{
			VetZ[i] = 1;
		}
	}
		

System.out.println(TSVs);
System.out.println((this.percentage/100)*this.z*(this.x-1)*this.y*2);

		
for(int i = 0; i < VetX.length; i++){
	
		System.out.print(VetX[i]+"\t");
		
}
System.out.println("");
for(int i = 0; i < VetY.length; i++){
	
	System.out.print(VetY[i]+"\t");
	
}
System.out.println("");
for(int i = 0; i < VetZ.length; i++){
	
	System.out.print(VetZ[i]+"\t");
	
}
System.out.println("");
		
		
		File file = new File (path+"Caso - "+z+"X"+x+"X"+y +"("+a+").txt");
		FileWriter esc = new FileWriter(file);
		BufferedWriter bf = new BufferedWriter(esc);
		try {
			/*int l = 0;
			if(z > 2)  l = z*3 -1;
			else if (z ==0) System.err.println("SEM CAMADA Z");
			if (z == 2) l = 5;
			else 	l = 3;
		*/for (int i = 0 ; i < (z*3)-1 ; i++ ){
					
			if(i % 3 == 0){
			
				for(int k = 0 ; k < x ; k++ ){
					for (int p = 0 ; p < x-1 ; p++){
						if(p == 0 && k ==0){
							esc.write(String.valueOf(VetX[((i/3)*(this.x-1)*this.y)+(k*(this.x-1))+p]));	
						
						}else{
						esc.write(" " + String.valueOf(VetX[((i/3)*(this.x-1)*this.y)+(k*(this.x-1))+p]));
						
						
					}}
					esc.write(";");
					
				}
				
				}
			else
			if(i % 3 == 1){
				
				for(int k = 0 ; k < (y-1) ; k++ ){
					for (int p = 0 ; p < y ; p++) {
					
						if(p == 0 && k == 0){
							esc.write(String.valueOf(VetY[(((i-1)/3)*this.x*(this.y-1))+(k*this.y)+p]));	
							
						}else{
							esc.write(" " + String.valueOf(VetY[(((i-1)/3)*this.x*(this.y-1))+(k*this.y)+p]));
						
						}
				}
				
					esc.write(";");
					}}
			
			else
				if(i % 3 == 2){
			
					for(int k = 0 ; k < y ; k++ ){
						for (int p = 0 ; p < x ; p++) {
							if(p == 0 && k == 0){
								esc.write(String.valueOf(VetZ[(((i-2)/3)*this.x*this.y)+(k*this.y)+p]));	
							
							}else{
								esc.write(" " + String.valueOf(VetZ[(((i-2)/3)*this.x*this.y)+(k*this.y)+p]));
							
							
						}
						
					}
						
						esc.write(";");


				}
			
			
		}
		
			esc.write("\n");	
		
			
		}	

		bf.close();	
		esc.close();
		System.out.println("ARQUIVO  "+(a+1)+" ---->   OK!");
		
		
		for(int i = 0; i < VetX.length; i++){

				VetX[i] = -1;
		}
		
		for(int i = 0; i < VetY.length; i++){
			
				VetY[i] = -1;
		}
		
		for(int i = 0; i < VetZ.length; i++){
			
				VetZ[i] = -1;
		}
		
	}
	

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	
	




	}

	

public void CompararPadraoDiagonalePuro() throws IOException{
	
	for (int a = 0  ; a < this.n ; a ++){
		
		int erros = 0;
		
		while(erros < ((this.percentage/100)*this.z*(this.x-1)*this.y*2)){		
			
			for (int i = 0 ; i < (z*3)-1 ; i++ ){
			
				if(i % 3 == 0){
					
					for(int k = 0 ; k < this.z*(this.x-1)*this.y ; k++ ){

						int aux = random.nextInt(2);
						if((aux == 1) && (VetXPuro[k] != 1) && (VetXDig[k] != 1)){
							if(erros < ((this.percentage/100)*this.z*(this.x-1)*this.y*2))
							{
								VetXPuro[k] = aux;
								VetXDig[k] = aux;
								erros++;
							}
							
						else if((VetXPuro[k] == -1) && (VetXDig[k] == -1) && (aux == 0))
						{
							VetXPuro[k] = aux;
							VetXDig[k] = aux;
						}
							
						}	
					}
				}
				
				else if(i % 3 == 1){
				
					for(int k = 0 ; k < this.z*this.x*(this.y-1) ; k++ ){
					
							int aux = random.nextInt(2);
							if((aux == 1) && (VetYPuro[k] != 1) && (VetYDig[k] != 1)){
								if(erros < ((this.percentage/100)*this.z*(this.x-1)*this.y*2))
								{
									VetYPuro[k] = aux;
									VetYDig[k] = aux;
									erros++;
								}
							}
							else if((VetYPuro[k] == -1) && (VetYDig[k] == -1) && (aux == 0))
							{
								VetYPuro[k] = aux;
								VetYDig[k] = aux;
							}
					}
				
						}
			
				else if(i % 3 == 2){
			
						for(int j = 0; j < (this.z-1); j++){
							for(int p = 0; p < this.x*this.y; p++){
							
								if(p % (this.x+1) == 0)
								{
									VetZDig[(j*this.x*this.y)+p] = 0;
								}
							
								else
								{
									VetZDig[(j*this.x*this.y)+p] = 1;
								}
							}
						}
				}
			}
		}
		
		
	for(int i = 0; i < VetXPuro.length; i++){
			
		if(VetXPuro[i] == -1)
		{
			VetXPuro[i] = 0;
			VetXDig[i] = 0;
		}
	}
	
	for(int i = 0; i < VetYPuro.length; i++){
		
		if(VetYPuro[i] == -1)
		{
			VetYPuro[i] = 0;
			VetYDig[i] = 0;
		}
	}
	
	for(int i = 0; i < VetZDig.length; i++){
		
		if(VetZDig[i] == -1)
		{
			VetZDig[i] = 0;
		}
	}
		
//Printa número de erros conseguidos e número de erros de fato.
System.out.println(erros);
System.out.println((this.percentage/100)*this.z*(this.x-1)*this.y*2);

//Printa as topologias.
//Puro
for(int i = 0; i < VetXPuro.length; i++){
	
		System.out.print(VetXPuro[i]+"\t");
		
}
System.out.println("");
for(int i = 0; i < VetYPuro.length; i++){
	
	System.out.print(VetYPuro[i]+"\t");
	
}
System.out.println("");
for(int i = 0; i < VetZPuro.length; i++){
	
	System.out.print(VetZPuro[i]+"\t");
	
}
System.out.println("");

//Dig
for(int i = 0; i < VetXDig.length; i++){
	
	System.out.print(VetXDig[i]+"\t");
	
}
System.out.println("");
for(int i = 0; i < VetYDig.length; i++){

System.out.print(VetYDig[i]+"\t");

}
System.out.println("");
for(int i = 0; i < VetZDig.length; i++){

System.out.print(VetZDig[i]+"\t");

}
System.out.println("");
		
		
		File file = new File (path+"Puro\\"+z+"X"+x+"X"+y +"\\"+percentage+"\\"+a+".txt");
		FileWriter esc = new FileWriter(file);
		BufferedWriter bf = new BufferedWriter(esc);
		
		File fileDig = new File(path+"Diagonal\\"+z+"X"+x+"X"+y +"\\"+percentage+"\\"+a+".txt");
		FileWriter escDig = new FileWriter(fileDig);
		BufferedWriter bfDig = new BufferedWriter(escDig);
		
		try {
			/*int l = 0;
			if(z > 2)  l = z*3 -1;
			else if (z ==0) System.err.println("SEM CAMADA Z");
			if (z == 2) l = 5;
			else 	l = 3;
		*/for (int i = 0 ; i < (z*3)-1 ; i++ ){
					
			if(i % 3 == 0){
			
				for(int k = 0 ; k < x ; k++ ){
					for (int p = 0 ; p < x-1 ; p++){
						if(p == 0 && k ==0){
							esc.write(String.valueOf(VetXPuro[((i/3)*(this.x-1)*this.y)+(k*(this.x-1))+p]));
							escDig.write(String.valueOf(VetXDig[((i/3)*(this.x-1)*this.y)+(k*(this.x-1))+p]));	
						
						}else{
						esc.write(" " + String.valueOf(VetXPuro[((i/3)*(this.x-1)*this.y)+(k*(this.x-1))+p]));
						escDig.write(" " + String.valueOf(VetXDig[((i/3)*(this.x-1)*this.y)+(k*(this.x-1))+p]));
						
						
					}}
					esc.write(";");
					escDig.write(";");
					
				}
				
				}
			else
			if(i % 3 == 1){
				
				for(int k = 0 ; k < (y-1) ; k++ ){
					for (int p = 0 ; p < y ; p++) {
					
						if(p == 0 && k == 0){
							esc.write(String.valueOf(VetYPuro[(((i-1)/3)*this.x*(this.y-1))+(k*this.y)+p]));
							escDig.write(String.valueOf(VetYDig[(((i-1)/3)*this.x*(this.y-1))+(k*this.y)+p]));	
							
						}else{
							esc.write(" " + String.valueOf(VetYPuro[(((i-1)/3)*this.x*(this.y-1))+(k*this.y)+p]));
							escDig.write(" " + String.valueOf(VetYDig[(((i-1)/3)*this.x*(this.y-1))+(k*this.y)+p]));
						
						}
				}
				
					esc.write(";");
					escDig.write(";");
					}}
			
			else
				if(i % 3 == 2){
			
					for(int k = 0 ; k < y ; k++ ){
						for (int p = 0 ; p < x ; p++) {
							if(p == 0 && k == 0){
								esc.write(String.valueOf(VetZPuro[(k*this.x)+p]));
								escDig.write(String.valueOf(VetZDig[(k*this.x)+p]));
							
							}else{
								esc.write(" " + String.valueOf(VetZPuro[(k*this.x)+p]));
								escDig.write(" " + String.valueOf(VetZDig[(k*this.x)+p]));
							
							
						}
						
					}
						
						esc.write(";");
						escDig.write(";");


				}
			
			
		}
		
			esc.write("\n");
			escDig.write("\n");
		
			
		}	

		bf.close();
		bfDig.close();
		esc.close();
		escDig.close();
		System.out.println("ARQUIVOS  "+(a+1)+" ---->   OK!");
		
		
		for(int i = 0; i < VetXPuro.length; i++){

				VetXPuro[i] = -1;
				VetXDig[i] = -1;
		}
		
		for(int i = 0; i < VetYPuro.length; i++){
			
				VetYPuro[i] = -1;
				VetYDig[i] = -1;
		}
		
		for(int i = 0; i < VetZDig.length; i++){
			
				VetZDig[i] = -1;
		}
		
	}
	

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	
	




	}

}
