import java.util.Scanner;
import java.util.Arrays;

public class Merge {
    
    public  void mergeSort(int vec[]){
        if(vec.length<=1) return;
        int mitad= vec.length/2;
        int izq[]=Arrays.copyOfRange(vec, 0, mitad);
        int der[]=Arrays.copyOfRange(vec, mitad, vec.length);
        mergeSort(izq);
        mergeSort(der);       
        combinarVector(vec, izq, der);
}

public  void combinarVector(int v[], int izq[],int der[]){
        int i=0;
        int j=0;
        for(int k=0;k<v.length;k++){
                if(i>=izq.length){
                        v[k]=der[j];
                        j++;
                        continue;
                }
                if(j>=der.length){
                        v[k]=izq[i];
                        i++;
                        continue;
                }
                if(izq[i]<der[j]){
                        v[k]=izq[i];
                        i++;
                }else{
                        v[k]=der[j];
                        j++;
                }
        }
}
}