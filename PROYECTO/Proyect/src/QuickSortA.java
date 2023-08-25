public class QuickSortA {

    public void quicksort(int[] Arreglo, int Izquierdo, int Derecho)
    {
        int Pivote = Arreglo[(Izquierdo + Derecho) / 2];
        int i = Izquierdo;
        int d = Derecho;
        boolean Bandera = true;
        do
        {
            Bandera = false;
            while (Arreglo[i] < Pivote)
            {
                i++;
            }
            while (Arreglo[d] > Pivote)
            {
                d = d - 1;
            }
            if (i <= d)
            {
                int Auxiliar;
                Auxiliar = Arreglo[i];
                Arreglo[i] = Arreglo[d];
                Arreglo[d] = Auxiliar;
                i = i + 1;
                d = d - 1;
                Bandera = true;
            }
        } while (i <= d && Bandera == true);
        if (Izquierdo < d)
        {
            quicksort(Arreglo, Izquierdo, d);
        }
        if (i < Derecho)
        {
            quicksort(Arreglo, d + 1, Derecho);
        }
        
        
    }
}
