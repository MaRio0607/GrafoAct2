//Codigo para determinar si un grafo es euleriano o no, 
//Por Mario Cuevas delgado Y Karim Sosa Perez
import java.io.*;
import java.util.*;
import java.util.LinkedList;
 

class Grafo{
    private int V;  
 
    // Array para la lista que se usara
    private LinkedList<Integer> adj[];
 
    // Constructor donde se establece el numero de vertices
    Grafo(int v){
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    //Para Agregar arista en el grafo
    void Ari(int v, int w){
        adj[v].add(w);//El punto de donde sale
        adj[w].add(v); //El punto alque se dirige
    }
 
    // Funcion Búsqueda en profundidad (Depth-first search)
    void DFSUtil(int v,boolean visitado[]){
        // Marca el nodo como visitado
        visitado[v] = true;
 
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()){
            int n = i.next();
            if (!visitado[n])
                DFSUtil(n, visitado);
        }
    }
 
    // Metodo para verifcar la conexion entre aristas
    boolean Conectado(){
        // Toas las vertices que sean verificado
        boolean visto[] = new boolean[V];
        int i;
        for (i = 0; i < V; i++)
            visto[i] = false;
 
        for (i = 0; i < V; i++)
            if (adj[i].size() != 0)
                break;
 
        if (i == V)
            return true;
 
        DFSUtil(i, visto);
 
        for (i = 0; i < V; i++)
           if (visto[i] == false && adj[i].size() > 0)
                return false;
 
        return true;
    }
 
    //Se determina si el grafo es euleriano o no
    int Euleriano() {
        // revisa si todas las vertices estan conectadas
        if (Conectado() == false)
            return 0;
 
        //Cuanta los vertices d egrado inpar
        int odd = 0;
        for (int i = 0; i < V; i++)
            if (adj[i].size()%2!=0)
                odd++;
 
        // si son mas de dos no son eulerianos
        if (odd > 2)
            return 0;
 
        //si es solo uno no se hace ciclo pero si camino
        return (odd==2)? 1 : 2;
    }
 
    // Function to run test cases
    void Prueba(){
        int res = Euleriano();
        if (res == 0)
            System.out.println("El grafo no es euleriano");
        else if (res == 1)
            System.out.println("El grafo es un camino euleriano");
        else
           System.out.println("El grafo es un ciclo euleriano");
    }
 
    public static void main(String args[]) {
        // Grafo g1 = new Grafo(10);
        // g1.Ari(0, 2);
        // g1.Ari(2, 1);
        // g1.Ari(1 ,5);
        // g1.Ari(5 ,4);
        // g1.Ari(4 ,3);
        // g1.Ari(3 ,2);
        // g1.Ari(2 ,9);
        // g1.Ari(9 ,1);
        // g1.Ari(1 ,8);
        // g1.Ari(8 ,5);
        // g1.Ari(5 ,6);
        // g1.Ari(6 ,4);
        // g1.Ari(4 ,7);
        // g1.Ari(7 ,3);
        // g1.Ari(3 ,0);
        // g1.Ari(0 ,9);
        // g1.Ari(9 ,8);
        // g1.Ari(8 ,6);
        // g1.Ari(6 ,7);
        // g1.Ari(7 ,0);

        // g1.Prueba();

        // Grafo g2 = new Grafo(10);
        // g2.Ari(0, 2);
        // g2.Ari(2, 1);
        // g2.Ari(1 ,5);
        // g2.Ari(5 ,4);
        // g2.Ari(4 ,3);
        // g2.Ari(3 ,2);
        // g2.Ari(2 ,9);
        // g2.Ari(9 ,1);
        // g2.Ari(1 ,8);
        // g2.Ari(8 ,5);
        // g2.Ari(5 ,6);
        // g2.Ari(6 ,4);
        // g2.Ari(3 ,0);
        // g2.Ari(0 ,9);
        // g2.Ari(9 ,8);
        // g2.Ari(8 ,6);

        // g2.Prueba();
 
        // Grafo g3 = new Grafo(10);
        // g3.Ari(0, 2);
        // g3.Ari(2, 1);
        // g3.Ari(1 ,5);
        // g3.Ari(5 ,4);
        // g3.Ari(4 ,3);
        // g3.Ari(3 ,2);
        // g3.Ari(2 ,9);
        // g3.Ari(9 ,1);
        // g3.Ari(1 ,8);
        // g3.Ari(8 ,5);
        // g3.Ari(5 ,6);
        // g3.Ari(6 ,4);
        // g3.Ari(4 ,7);
        // g3.Ari(7 ,3);
        // g3.Ari(3 ,0);
        // g3.Ari(0 ,9);
        // g3.Ari(8 ,6);
        // g3.Ari(6 ,7);
        // g3.Ari(7 ,0);

        // g3.Prueba();        
 
        // Grafo g4 = new Grafo(10);
        // g4.Ari(0, 2);
        // g4.Ari(2, 1);
        // g4.Ari(1 ,5);
        // g4.Ari(5 ,4);
        // g4.Ari(4 ,3);
        // g4.Ari(3 ,2);
        // g4.Ari(2 ,9);
        // g4.Ari(9 ,1);
        // g4.Ari(1 ,8);
        // g4.Ari(8 ,5);
        // g4.Ari(5 ,6);
        // g4.Ari(6 ,4);
        // g4.Ari(4 ,7);
        // g4.Ari(7 ,3);
        // g4.Ari(3 ,0);
        // g4.Ari(0 ,9);
        // g4.Ari(8 ,6);
        // g4.Ari(7 ,0);

        // g4.Prueba();

        // Grafo g5 = new Grafo(10);
        // g5.Ari(0, 2);
        // g5.Ari(2, 1);
        // g5.Ari(1 ,5);
        // g5.Ari(5 ,6);
        // g5.Ari(6 ,8);
        // g5.Ari(8 ,5);
        // g5.Ari(8 ,1);
        // g5.Ari(7 ,0);
        // g5.Ari(0 ,3);
        // g5.Ari(3 ,7);
        // g5.Ari(2 ,3);

        // g5.Prueba();

        Grafo g6 = new Grafo(10);
        g6.Ari(0, 9);
        g6.Ari(9 ,8);
        g6.Ari(8 ,5);
        g6.Ari(5 ,4);
        g6.Ari(4 ,3);
        g6.Ari(3 ,7);
        g6.Ari(7 ,6);
        g6.Ari(6 ,5);
        g6.Ari(6 ,8);
        g6.Ari(7 ,0);

        g6.Prueba();


        // Grafo g2 = new Grafo(5);
        // g2.Ari(1, 0);
        // g2.Ari(0, 2);
        // g2.Ari(2, 1);
        // g2.Ari(0, 3);
        // g2.Ari(3, 4);
        // g2.Ari(4, 0);
        // g2.Prueba();
 
    }
}