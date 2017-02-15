import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InputFile{
	 //read file from Projet1.txt
	 public InputFile(String filename) throws IOException{
		readFile(filename);
	}
	 /**
	  * 
	  * @param Fname is the name of the Inputfile
	  * @throws IOException
	  */
	 public void readFile(String Fname) throws IOException{
		 
	
		 BufferedReader br= new BufferedReader(
				 				new InputStreamReader(
				 					new FileInputStream(Fname)));
		 String line= br.readLine();//read the first line
		 StringTokenizer tokenized = new StringTokenizer(line, " ");
		 //read each vertex in the first line
		String vertex;
		Vertex v;
		int count=0;
		
		
			/**
			 * add each of the vertex in a linked list
			 */
			DoublyLinkedList a=new DoublyLinkedList();//create a new linked list
			vertex=tokenized.nextToken();//read the next character
			v= new Vertex(vertex);//pass the vertex
			a.add(v);//add to linked list
			count++;//count number of linked list
			DoublyLinkedList b=new DoublyLinkedList();
			vertex=tokenized.nextToken();
			v= new Vertex(vertex);
			b.add(v);
			count++;
			DoublyLinkedList c=new DoublyLinkedList();
			vertex=tokenized.nextToken();
			v= new Vertex(vertex);
			c.add(v);
			count++;
			DoublyLinkedList d=new DoublyLinkedList();
			vertex=tokenized.nextToken();
			v= new Vertex(vertex);
			d.add(v);
			count++;
			DoublyLinkedList e=new DoublyLinkedList();
			vertex=tokenized.nextToken();
			v= new Vertex(vertex);
			e.add(v);
			count++;
			DoublyLinkedList f=new DoublyLinkedList();
			vertex=tokenized.nextToken();
			v= new Vertex(vertex);
			f.add(v);
			count++;
		/**
		 * find the adjacency matrix in the corresponding 
		 * linked list and add to the list
		 */		
		int[][] array= new int [count][count];//create an array
		int z=0;
		line=br.readLine();	//read the next line
		tokenized = new StringTokenizer(line, " ");//read the character seperated by space
				while(tokenized.hasMoreTokens()){//while it does not reach to the end of the line
					vertex=tokenized.nextToken();//go on next character
					array[0][z]=Integer.parseInt(vertex);//convert string to int and save in array
					
					if(array[0][z]==1){
						char vx=(char)(z+65);
						a.add(vx);//only adjacent vertices have value of 1
									//convert to character and add to the linkedlist
						}
					z++;//array column++
				}
				
		z=0;
		line=br.readLine();	
		tokenized = new StringTokenizer(line, " ");
		while(tokenized.hasMoreTokens()){
			vertex=tokenized.nextToken();
			array[0][z]=Integer.parseInt(vertex);
			if(array[0][z]==1){
				char vx=(char)(z+65);
				b.add(vx);
				
				}
			z++;
		}
		z=0;
		line=br.readLine();	
		tokenized = new StringTokenizer(line, " ");
		while(tokenized.hasMoreTokens()){
			vertex=tokenized.nextToken();
			array[0][z]=Integer.parseInt(vertex);
			if(array[0][z]==1){
				char vx=(char)(z+65);
				c.add(vx);
			
				}
			z++;
			}
		z=0;
		line=br.readLine();
		tokenized = new StringTokenizer(line, " ");
		while(tokenized.hasMoreTokens()){
			vertex=tokenized.nextToken();
			array[0][z]=Integer.parseInt(vertex);
			if(array[0][z]==1){
				char vx=(char)(z+65);
				d.add(vx);
				
				}
			z++;
			}
		z=0;
		line=br.readLine();	
		tokenized = new StringTokenizer(line, " ");
		while(tokenized.hasMoreTokens()){
			vertex=tokenized.nextToken();
			array[0][z]=Integer.parseInt(vertex);
			if(array[0][z]==1){
				char vx=(char)(z+65);
				e.add(vx);												
				
				}
			z++;
			}
		z=0;
		line=br.readLine();	
		tokenized = new StringTokenizer(line, " ");
		while(tokenized.hasMoreTokens()){
			vertex=tokenized.nextToken();
			array[0][z]=Integer.parseInt(vertex);
			if(array[0][z]==1){
				char vx=(char)(z+65);
				f.add(vx);
				
				}
			z++;
			}				
		br.close();//close file
		
		/**
		 * print out the lists
		 */
	    System.out.println(" The adjacency list for vertex A is ");
	    a.display();
	    
	
		System.out.println(" The adjacency list for vertex B is ");
		 b.display();
		
		System.out.println(" The adjacency list for vertex C is ");
		 c.display();

		System.out.println(" The adjacency list for vertex D is ");
		 d.display();

		System.out.println(" The adjacency list for vertex E is ");
		 e.display();

		System.out.println(" The adjacency list for vertex F is ");
		 f.display();
  }
}



		
		 
		 
		 
	

