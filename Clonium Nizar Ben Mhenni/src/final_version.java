import java.util.Scanner;

public class final_version {

		static Scanner sc = new Scanner(System.in);
		
		public static void main(String[] args) {
			{
				int j=0;
				int x;
				int y;	
				int a=0;
				int lvl=0;
				char o;
				//presentation
				System.out.println("#==============================================================================#");
				System.out.println("#                                   Clonuim                                    #");
				System.out.println("#------------------------------------------------------------------------------#");
				System.out.println("# Author:      BEN MHENNI              -           Fac de Blois                #");
				System.out.println("# Copyright:   (c) BEN MHENNI 2016                                             #");
				System.out.println("# tous droits réservés                                                         #");
				System.out.println("#==============================================================================#");
				System.out.println();
				System.out.println();
				//demande taille du tableau
				do{
					System.out.println("entrez la taille du tableau ?x? (une seule valeur entre 5 et 10): ");
					x=	sc.nextInt();
	
					if(x!=5 && x!=6 && x!=7 && x!=8 && x!=9 && x!=10)
						System.out.println("!!!! Erreur tableau non comforme !!!!");
					
				}while(x!=5 && x!=6 && x!=7 && x!=8 && x!=9 && x!=10);
				
				Scanner sc1 = new Scanner(System.in);
				
				//demande si il joue contre l'ordi
				do{
					System.out.println("Jouer contre l'ordi (y/n)");
					o=sc1.nextLine().charAt(0);
	
					if(o!='y' && o!='n')
						System.out.println("!!!! Erreur valeur non comforme !!!!");
					
				}while(o!='y' && o!='n');
				
				//demande le niveau de l'ordi
				if(o=='y')
				do{
					System.out.println("Le niveau de l'ordi(valeur entre 0 et 1)");
					lvl=sc.nextInt();
	
					if(lvl!=0 && lvl!=1)
						System.out.println("!!!! Erreur valeur non comforme !!!!");
					
				}while(lvl!=0 && lvl!=1);
				
				//demande le nombre de joueur
				do{
					if(o=='y'){
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					System.out.println("!!!! On ne peux pas jouer a plusieurs contre des ordis !!!!");
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					}
					System.out.println("entrez le nombre de joueur (de 2 a 4):");
					y= sc.nextInt();
						
	
					if(y!=2 && y!=3 && y!=4)
						System.out.println("Erreur nombre de jeu non comforme !");
				}while(y!=2 && y!=3 && y!=4);
				
				
				//debut du jeu 
				int[][] plat=new int[x][x];
				int[][] play=new int[x][x];
				
				//initialise les tableaux
				init(plat,play,x,y);
			{
				//Le jeu se lance
				do{
					//changer de joueur
					
					do{
						j=nextjoueur(j,y);
							
						for (int z=0;z<play.length;z++)
							for(int r=0;r<play.length;r++)
								if(play[z][r]==j)
									a++;
					}while(a==0);
					
					System.out.println();
					
					//affiche le tableau pour les joueur
					afficher(plat,play);
					System.out.println();
					
					//permet au joueur de jouer 
					if(o=='n' || j==1)
					increment(plat,play,j);
					
					//permet a l'ordi de jouer
				if(o=='y' && j!=1){
						joueOrdi(plat,play,j,lvl);
						System.out.println("l'ordi à jouer");
					}
					
					//permet de sortir du joue si l'un des deux a gagner
				}while (gagnant(play)==false);}
				
				afficher(plat,play);
				System.out.println();
				System.out.println("Félicitation : Le joueur "+j+" a gagner la partie !");
				System.out.println();
				System.out.println("Fin du jeu");

			}
				
		}	
			
			//methode init: initialise les tableau et la position des joueur(selon le nombre)
		    public static void init (int [][]mat,int [][]mat1, int valmax,int x)
		    {
		            for (int i=0; i<mat.length; i++)
		                    for(int j=0; j<mat[0].length; j++){
		                    	mat[i][j]=0;
		                    	mat1[i][j]=0;	
		                    }
		            //pour 2 joueur
		            if(x==2){
		            	mat[1][1]=3;
		            	mat[1][mat.length-2]=3;
		            	
		            	mat1[1][1]=1;
		            	mat1[1][mat.length-2]=2;
		            }
		            	
		            // pour 3 joueur
		            if(x==3){
		            	mat[1][1]=3;	            	
		            	mat[1][mat.length-2]=3;
		            	mat[mat.length-2][1]=3;
		            	
		            	mat1[1][1]=1;
		            	mat1[1][mat.length-2]=2;
		            	mat1[mat.length-2][1]=3;
		            }
		            // pour 4 joueur
		            if(x==4){
		            	mat[1][1]=3;
		            	mat[1][mat.length-2]=3;
		            	mat[mat.length-2][1]=3;
		            	mat[mat.length-2][mat[0].length-2]=3;
		            	
		            	mat1[1][1]=1;
		            	mat1[1][mat.length-2]=2;
		            	mat1[mat.length-2][1]=3;
		            	mat1[mat.length-2][mat[0].length-2]=4;
		            }   
		    }
			
		    
		  	    
		    //methode afficher: permet d'afficher le tableau (selon le joueur)
			public static void afficher(int [][]tab,int[][] tab1){
				System.out.print("X");
				for(int i=0;i<tab.length;i++)
					System.out.print("\t"+i);
				System.out.println();
				if(tab.length==10)
					System.out.print("  -------------------------------------------------------------------------------");
				if(tab.length==9)
					System.out.print("  --------------------------------------------------------------------------");
				if(tab.length==8)
					System.out.print("  ---------------------------------------------------------------");
				if(tab.length==7)
					System.out.print("  -------------------------------------------------------");
				if(tab.length==6)
					System.out.print("  -----------------------------------------------");
				if(tab.length==5)
					System.out.print("  ---------------------------------------");
				for(int i=0; i<tab.length; i++){
		        	System.out.println();
		        	System.out.print(i+"|\t");
		                for(int j=0; j<tab[0].length; j++){
		                	if ( tab1[i][j]==1)
		                		System.out.print("<"+tab[i][j]+"> \t");
		                	if ( tab1[i][j]==2)
		                		System.out.print("("+tab[i][j]+") \t");
		                	if ( tab1[i][j]==3)
		                		System.out.print("["+tab[i][j]+"] \t");
		                	if ( tab1[i][j]==4)
		                		System.out.print("{"+tab[i][j]+"} \t");
		                	if(tab1[i][j]!=1 && tab1[i][j]!=2 && tab1[i][j]!=3 && tab1[i][j]!=4)
		                	System.out.print(tab[i][j]+" \t");
		                		
		                }
				}
			}	
			
				
			//methode increment: permet d'augmenter la case (qui appartient au joueur) et de faire l'explosion si besoin .
			public static void increment(int [][]tab,int [][]tab1,int j){
				int c;
				int l;
				int s1;
				int s2;
				System.out.println();
				System.out.println("Au joueur numero "+j+" de jouer !");
				//le score a ajouter ici
				s1=score2(tab,tab1,j);
				s2=score1(tab,tab1,j);
				System.out.println("Le joueur "+j+" possedé "+s1+" Jeton. Le score du joueur "+j+" est de "+s2);
				System.out.println();
				
				//demande la ligne a incrementer 
				do{	
					System.out.println("Entrez la case a incrementer, la ligne de 0 à 4(une seule valeur)  : ");
					l= sc.nextInt();
				
					if(l!=0 && l!=1 && l!=2 && l!=3 && l!=4)
						System.out.println("!!!! Erreur: la valeur depasse du tableau !!!!");
					}while(l!=0 && l!=1 && l!=2 && l!=3 && l!=4);
				
				//demande la colonne a incrementer
				do{		
					System.out.println("Entrez la colonne :");
					c= sc.nextInt();
					

					if(c!=0 && c!=1 && c!=2 && c!=3 && c!=4)
						System.out.println("!!!! Erreur: la valeur depasse du tableau !!!!");
					System.out.println("la ligne choisi est "+l);
					}while(c!=0 && c!=1 && c!=2 && c!=3 && c!=4);
				
				//verifie si la case appartient bien au joueur et gere l'explosion
				if(j==tab1[l][c]){
						tab[l][c]++;
						if(tab[l][c]>=4)
							explo2(tab,tab1,l,c,j);
						j++;
				}
				//sinon elle recommence la demande
				else {
					System.out.println();
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					System.out.println("!!!! Cette case n'est pas a toi !!!!");
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					System.out.println();
					afficher(tab,tab1);
					System.out.println();
					increment(tab,tab1,j);
				}
				
			
			}

			
			//methode incrementOrdi: permet a l'ordi de jouer
			public static void joueOrdi(int[][] tab,int[][] tab1,int j,int lvl){
				int l=0;
				int c=0;
				int k=0;	
				int a=0;
				int b=0;

				
				//niveau 0 de l'ordi
				if(lvl==0)
				do{
					l = 0 + (int)(Math.random() * ((tab.length - 1) + 1));
					c = 0 + (int)(Math.random() * ((tab.length - 1) + 1));
					
					if(j==tab1[l][c]){
						tab[l][c]++;
						if(tab[l][c]>=4)
							explo2(tab,tab1,l,c,j);
						k++;
					}
				}while(k==0);
				
				//niveau 1 de l'ordi
				if(lvl==1){
					for(int i=0; i < tab.length ; i++ ){
						for(int e=0; e <tab.length ; e++){
							if(tab1[i][e]==j){
								if(tab[i][e]>tab[a][b]){
									a=i;
									b=e;}}
									
						}
					}
					System.out.println("La case choisi est "+a+","+b);
					if(j==tab1[a][b]){
						tab[a][b]++;
						if(tab[a][b]>=4)
							explo2(tab,tab1,a,b,j);
				
					
					}
				}
				
			}
					
			//methode nextjoueur
			public static int nextjoueur(int j,int y){
				
				
				if(y==2){
						j++;
						if(j>2)
							j=1;}
							
					if(y==3){
						j++;
						if(j>3)
							j=1;}
							
					if(y==4){
						j++;
						if(j>4)
							j=1;}
			
				return j;
				}
			
			
			
			//methode explo: gere les explo et recurence si besoin
			public static void explo2(int[][]tab,int[][]tab1, int l, int c,int s ){
				if(tab[l][c]>=4){
					tab[l][c]-=4;
					if(tab[l][c]==0)
						tab1[l][c]=0;
					//explose dans les 4 sens et test pour la reccurenc
					if(l<tab.length-1){
						tab[l+1][c]+=1;
						tab1[l+1][c]=s;
						if(tab[l+1][c]>=4)
							explo2(tab,tab1,l+1,c,s);
					}
					
					if(c<tab.length-1){
						tab[l][c+1]+=1;
						tab1[l][c+1]=s;
						if(tab[l][c+1]>=4)
							explo2(tab,tab1,l,c+1,s);
					}
					
					
					if(l>0){
						tab[l-1][c]+=1;
						tab1[l-1][c]=s;
						if(tab[l-1][c]>=4)
							explo2(tab,tab1,l-1,c,s);
					}
				
					if(c>0){
						tab[l][c-1]+=1;
						tab1[l][c-1]=s;
						if(tab[l][c-1]>=4)
							explo2(tab,tab1,l,c-1,s);
						
					}
				}
			}
			

				
			//methode gagnant: regarde si l'un des joueur a gagner
			public static boolean gagnant(int [][]tab){
				int a =0;
				int b =0;
				int c =0;
				int d =0;
				//parcour le tableau
				for(int i=0; i < tab.length ; i++ ){
					for(int j=0; j <tab.length ; j++){
						//regard combien de joueur sont encore en jeu
						if(tab[i][j]==1)
							a++;
						if(tab[i][j]==2)
							b++;
						if(tab[i][j]==3)
							c++;
						if(tab[i][j]==4)
							d++;
					}}
				//fini si l'un seul des joueur est dispo
					if( (a>=1 && b==0 && c==0 && d==0) ||( a==0 && b>=1 && c==0 && d==0 ) || ( a==0 && b==0 && c>=1 && d==0 )||( a==0 && b==1 && c==0 && d>=0 )){
						return true;
					}
					else return false;
				}
			
			//methode score divisé en 2 car on ne peux pas retourner 2 valuer dans la meme methode
			
			//methode score: calcule le score sur les jeton
			public static int score1(int [][]tab,int [][]tab1,int y){
				int a=0;
				for(int i=0; i < tab.length ; i++ ){
					for(int j=0; j <tab.length ; j++){
						if(tab1[i][j]==y){
							a=a+tab[i][j];
						}
							
					}
				}
				return a;
			}
			
			//methode score: calcule le nombre de jeton
			public static int score2(int [][]tab,int [][]tab1,int y){
				int a=0;
				for(int i=0; i < tab.length ; i++ ){
					for(int j=0; j <tab.length ; j++){
						if(tab1[i][j]==y){
							a++;
						}
							
					}
				}
				return a;
			}
			
			
			
		
			
}