/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findeulerspath;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Qosmio
 */
public class Findeulerspath {

    int[][] adjMatrix;
    int[] eulPath;
    ArrayList<Integer> startVertices = new ArrayList<Integer>();
    ArrayList<String> EPath = new ArrayList <String>();
    /**
     * @param args the command line arguments
     */
    
    public Findeulerspath(int vertices, int[][] adjMatrix){
        this.adjMatrix = new int[vertices + 1][vertices + 1];
        this.adjMatrix = adjMatrix;
        }
    
    public static void main(String[] args) {
        Scanner scanner = null;
        int verticesNumber;
         try
        {
            // read the number of nodes
            System.out.println("Enter the number of vertices in the graph");
            scanner = new Scanner(System.in);
            verticesNumber = scanner.nextInt();
 
            // read the adjacency matrix
            int adjacency_matrix[][] = new int[verticesNumber+1][verticesNumber+1];
            System.out.println("Enter the adjacency matrix");
            for (int i = 1; i <= verticesNumber; i++)
            {
                for (int j = 1; j <= verticesNumber; j++)
                {	
                    adjacency_matrix[i][j] = scanner.nextInt();
                }
            }
 
           
            
            
           Findeulerspath ep = new Findeulerspath(verticesNumber, adjacency_matrix);
           ep.checkStartVertex();
           
           System.out.println("Found " + ep.startVertices.size() + " start points: " );
           ep.printStartVertices();
           System.out.println("The euler path or euler circuit is ");
           ep.findEPath(ep.startVertices.get(0));
          // ep.findEPath(4);
        } catch (InputMismatchException inputMismatch)
         {
             System.out.println("Wrong Input format");
         }
        scanner.close();
       
    }

    public void checkStartVertex() {
        int edgesForVertex = 0;
        //int[] visited;
        for(int x=1; x<adjMatrix.length;x++){
            for(int y=1;y<adjMatrix.length; y++){
                if(adjMatrix[x][y] == 1 || adjMatrix[y][x] == 1){
                    edgesForVertex++;
                }
                
            }
            //System.out.println("Vertex degree for vertex: " + x + " is " + edgesForVertex);
            
            if((edgesForVertex % 2) !=0){
                startVertices.add(x);
            }
            // reset edge count
            edgesForVertex = 0;
            
        }
        
        
       
        
    }
    public void printStartVertices(){
     for(int x=0; x<startVertices.size();x++){
        System.out.println(startVertices.get(x));
        }
    }

    private void findEPath(int startVertex) {
        for(int x=startVertex; x< adjMatrix.length;x++){
            
            for(int y = 1;y<adjMatrix.length;y++){
                if(adjMatrix[x][y] == 1 ){
                    //
                    EPath.add("From: " + x + " To: " + y);
                    // remove this edge
                    removeEdge(x,y);
                    x = y;
                    y=0;
                }
            }
        
        }
        
        for(int d=0;d<EPath.size();d++){
        System.out.println(EPath.get(d));
        }
    }

    private void removeEdge(int x, int y) {
       adjMatrix[x][y] = 0;
       adjMatrix[y][x] = 0;
    }
    
   
        
        



    
}

