/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

/**
 *
 * @author vuna
 */
public class BlanceCourse {
    int[] X; // save index of teacher for course i
    boolean [][] conflict; // conflict of course i and course j
    boolean [][] teach; // teacher t can be teach course i
    int f;
    int[] X_best;
    int[] f_best;
    int m;
    int n;
    
    public BlanceCourse(int m, int n, boolean conflict[][], boolean teach[][]){
        this.m = m;
        this.n = n;
        this.conflict = conflict;
        this.teach = teach;
        X = new int[n];
        for( int i = 0; i < n; i++){
            X[i] = -1;
        }
        
    }
    
    public void solve(){
        TRY(0);
    }
    
    public void solution(){
        for(int index = 0; index < n; index++){
            System.err.print(X[index]);
        }
        System.err.println();
    }
    public boolean check(int v, int k){
        boolean[] buff = new boolean[m];
        for (int i = 0; i< m; i++){
            buff[i] = false;
        }
        // tim danh sach giao vien day mon k
        for(int i =0; i< m; i++){
            if(teach[i][k]){
                buff[i] = true;
            }
        }
        // loai bo giao vien conflict mon
        for(int i =0; i< k; i++){
            if(conflict[k][i]){
                buff[X[i]] = false;
            }
        }
        return buff[v];
    }
    // try for k course
    public void TRY(int k){
        int v;
        for (v = 0; v < m; v++){
            if(check(v, k)){
                X[k] = v;
                if(k == n-1){
                    solution();
                }else{
                    TRY(k + 1);
                }
                X[k] = -1;// set default value is -1 if k course have no teacher
            }
        }
    }
    // print
    public void printArr(){
        for(int i = 0 ; i < n; i++){
            System.out.println(X[i]);
        }
    }
    public static void main(String[] args) {
        boolean[][] conflict = {
            {false,true,true,true,false,false,true,true,false},
            {true,false,true,false,true,false,true,false,false},
            {true,true,false,false,true,false,false,false,false},
            {true,false,false,false,false,false,false,true,true},
            {false,true,true,false,false,false,true,false,false},
            {false,false,false,false,false,false,false,false,true},
            {true,true,false,false,true,false,false,false,false},
            {true,false,false,true,false,false,false,false,false},
            {false,false,false,true,false,true,false,false,false}
        };
        boolean[][] teach = {
            {true,true,true,false,true,false,false,false,false},
            {true,true,false,false,true,true,false,true,false},
            {true,true,false,true,true,false,true,false,true},
            {false,false,true,true,true,false,false,false,true}
        };
        BlanceCourse bc = new BlanceCourse(4, 9, conflict, teach);
        bc.solve();
    }
}
