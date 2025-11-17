import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    private static class Elemento implements Comparable<Elemento> {
        int valor;
        int indiceLista;
        int indiceElemento;

        public Elemento(int valor, int indiceLista, int indiceElemento) {
            this.valor = valor;
            this.indiceLista = indiceLista;
            this.indiceElemento = indiceElemento;
        }

        @Override
        public int compareTo(Elemento outro) {
            return Integer.compare(this.valor, outro.valor);
        }
    }

    public static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        List<Integer> resultado = new ArrayList<>();
        PriorityQueue<Elemento> minHeap = new PriorityQueue<>();

        for (int i = 0; i < lists.size(); i++) {
            List<Integer> listaAtual = lists.get(i);
            if (listaAtual != null && !listaAtual.isEmpty()) {
                minHeap.add(new Elemento(listaAtual.get(0), i, 0));
            }
        }

        while (!minHeap.isEmpty()) {
            Elemento menorElemento = minHeap.poll();
            resultado.add(menorElemento.valor);

            int indiceListaOrigem = menorElemento.indiceLista;
            int proximoIndiceElemento = menorElemento.indiceElemento + 1;
            
            List<Integer> listaOrigem = lists.get(indiceListaOrigem);

            if (proximoIndiceElemento < listaOrigem.size()) {
                minHeap.add(new Elemento(
                    listaOrigem.get(proximoIndiceElemento),
                    indiceListaOrigem,
                    proximoIndiceElemento
                ));
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        List<Integer> lista1 = Arrays.asList(1, 4, 7, 9);
        List<Integer> lista2 = Arrays.asList(2, 5, 8, 10);
        List<Integer> lista3 = Arrays.asList(0, 3, 6);

        List<List<Integer>> todasAsListas = new ArrayList<>();
        todasAsListas.add(lista1);
        todasAsListas.add(lista2);
        todasAsListas.add(lista3);

        System.out.println("Listas Originais:");
        for (List<Integer> lista : todasAsListas) {
            System.out.println(lista);
        }

        List<Integer> resultadoMesclado = mergeKSortedLists(todasAsListas);

        System.out.println("\nLista Mesclada e Ordenada:");
        System.out.println(resultadoMesclado);
    }
}
