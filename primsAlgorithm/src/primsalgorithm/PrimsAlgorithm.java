/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primsalgorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Qosmio
 */
public class PrimsAlgorithm {

    

    
    ArrayList<Vertex> vertices = new ArrayList<Vertex>();
    int totalVertices=0;
    //int[][] adjMatrix;
    int[][] adjMatrix={{0,0,5,0,0,0,0,0},
                       {0,0,9,0,0,8,4,0},
                       {5,9,0,0,6,0,0,0},
                       {0,0,0,0,0,9,0,4},
                       {0,0,6,0,0,0,0,0},
                       {0,8,0,9,0,0,3,0},
                       {0,4,0,0,0,3,0,0},
                       {0,0,0,4,0,0,0,0}
    };
    
//    int[][] adjMatrix = {
//        {0,9,0,0,3,0,0,0},
//        {9,0,0,9,0,0,0,0},
//        {0,0,0,0,0,8,3,0},
//        {0,9,0,0,0,8,0,4},
//        {3,0,0,0,0,0,0,0},
//        {0,0,8,8,0,0,0,0},
//        {0,0,3,0,0,0,0,7},
//            {0,0,0,4,0,0,7,0}
//    
//    };
    
    PrimsAlgorithm(int[][] adjacent_matrix, int totalVertices){
    //this.adjMatrix = adjacent_matrix;
    this.totalVertices = totalVertices;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = null;
        int verticesNumber=0;
          // read the number of nodes
            System.out.println("Enter the number of vertices in the graph");
            scanner = new Scanner(System.in);
            verticesNumber = scanner.nextInt();
 
//            // read the adjacency matrix
           int adjacency_matrix[][] = new int[verticesNumber+1][verticesNumber+1];
//            System.out.println("Enter the adjacency matrix");
//            for (int i = 0; i < verticesNumber; i++)
//            {
//                for (int j = 0; j < verticesNumber; j++)
//                {	
//                    adjacency_matrix[i][j] = scanner.nextInt();
//                }
//            }
            
        
            
            PrimsAlgorithm pa = new PrimsAlgorithm(adjacency_matrix, verticesNumber);
            
            pa.createVertexList();
            
           
            
            pa.performPrismAlgorithm();
            
            pa.printListData();
            
            // TEST
            
           
            
            //System.out.println("done");
            //pa.printMatrix();
    }
    
    
    
    public void printMatrix(){
    
        for(int x=0;x<this.adjMatrix.length;x++){
            
            for(int y=0;y<this.adjMatrix.length;y++){
            
                System.out.print(this.adjMatrix[x][y] + " ");
                
            }
            System.out.println("");
        }
    
    }
    
    
    public void createVertexList(){
    
        for(int x=0;x<=this.totalVertices;x++){
        
        
            Vertex v = new Vertex();
            
            this.vertices.add(v);
            
        }
    
    }
    
    
    public void performPrismAlgorithm(){
            
        // setting initial start vertex
        this.vertices.get(0).setCost(0);
        //double currentCost = 1;
     
        for(int x=0;x<vertices.size();x++){
            
            if(vertices.get(x).getCost() < Double.POSITIVE_INFINITY && vertices.get(x).getKnown() != true && isCheapest(x)){
                    vertices.get(x).setKnown(true);
                    // get row for the vertex from adj matrix
                    int[] row = getRow(x);
                    
                    for(int p=0;p<row.length;p++){
                        
                        if(row[p] > 0){
                            if(vertices.get(p).getKnown() != true){
                            vertices.get(p).setCost(row[p]);
                            vertices.get(p).setPath(x);
                            }
                        }
                    }
                      //reset x;
                          
                    x = 0;
                    
                    
            }
        
        }
        
        
    }
    
    public void printListData(){
    
        for(int x=0;x<this.vertices.size();x++){
        
            System.out.println("vertex: " + x + " | path: " + this.vertices.get(x).getPath() + " | Cost: " + this.vertices.get(x).getCost());
            System.out.println("---------------------------------------");
            
        
        }
    
    }
    
    
    public boolean isCheapest(int vertex){
        
        double cheapestCost = vertices.get(vertex).getCost();
        boolean isCheap = true;
        for(int x=0;x<vertices.size();x++){
            if(vertices.get(x).getCost() < cheapestCost && vertices.get(x).getKnown() != true){
               isCheap = false;
               break; 
            }
            
        }
        
        
        
    return isCheap;
    }
    
    public int[] getRow(int forVertex){
    
        return this.adjMatrix[forVertex];
        
    }
 
    
    
    class Vertex{
    
        private boolean Known = false;
        private double Cost = Double.POSITIVE_INFINITY;
        private int Path = -1;
        
        
        public void setKnown(boolean value){
            this.Known = value;
        }
        
        public void setCost(int cost){
            this.Cost = cost;
        }
        
        public void setPath(int pathValue){
            this.Path = pathValue;
        }
        
        boolean getKnown(){
        return this.Known;
        }
        
        double getCost(){
        return this.Cost;
        }
        
        int getPath(){
        return this.Path;
        }
        
        
        
        
        
        
        
    
    }
    
    
    
    
}
