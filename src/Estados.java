import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Estados {

    public static void main(String[] args) {

        Map<String, Siglas> estados = new HashMap<>();

        estados.put("PE", new Siglas("PE", 9616621));
        estados.put("AL", new Siglas("AL", 3351543));
        estados.put("CE", new Siglas("CE", 9187103));
        estados.put("RN", new Siglas("RN", 3534265));

        System.out.println("Ordem aleatória");
        for (Map.Entry<String, Siglas> regiao : estados.entrySet()) {
            System.out.println(regiao.getKey() + " - " + regiao.getValue().getSiglasEstado() + ": "
                    + regiao.getValue().getPopulacao());
        }
        System.out.println("--------------------");

        estados.put("RN", new Siglas("RN", 3534165));

        System.out.println("Após atualizar RN");
        for (Map.Entry<String, Siglas> regiao : estados.entrySet()) {
            System.out.println(regiao.getKey() + " - " + regiao.getValue().getSiglasEstado() + ": "
                    + regiao.getValue().getPopulacao());
        }
        System.out.println("--------------------");

        System.out.println("PB está no dicionário? " + estados.containsKey("PB"));

        System.out.println("--------------------");

        estados.put("PB", new Siglas("PB", 4039277));

        System.out.println("PB está no dicionário? " + estados.containsKey("PB"));
        System.out.println("--------------------");

        System.out.println("Após adicionar PB");
        for (Map.Entry<String, Siglas> regiao : estados.entrySet()) {
            System.out.println(regiao.getKey() + " - " + regiao.getValue().getSiglasEstado() + ": "
                    + regiao.getValue().getPopulacao());
        }
        System.out.println("--------------------");

        System.out.println("Ordem de inserção");

        Map<String, Siglas> estados1 = new LinkedHashMap<>();
        estados1.put("PE", new Siglas("PE", 9616621));
        estados1.put("AL", new Siglas("AL", 3351543));
        estados1.put("CE", new Siglas("CE", 9187103));
        estados1.put("RN", new Siglas("RN", 3534265));

        for (Map.Entry<String, Siglas> regiao : estados1.entrySet()) {
            System.out.println(regiao.getKey() + " - " + regiao.getValue().getSiglasEstado() + ": "
                    + regiao.getValue().getPopulacao());
        }
        System.out.println("--------------------");

        System.out.println("Ordem alfabetica");

        Map<String, Siglas> estados2 = new TreeMap<>(estados);
        for (Map.Entry<String, Siglas> regiao : estados2.entrySet()) {
            System.out.println(regiao.getKey() + " - " + regiao.getValue().getSiglasEstado() + ": "
                    + regiao.getValue().getPopulacao());
        }
        System.out.println("--------------------");

        System.out.println("Ordem por população ");

        Set<Map.Entry<String, Siglas>> estadosOrdenadosPorPopulacao = new TreeSet<>(Comparator.comparing(
            cont -> cont.getValue().getPopulacao()));
        estadosOrdenadosPorPopulacao.addAll(estados.entrySet());
        for (Map.Entry<String, Siglas> entrada : estadosOrdenadosPorPopulacao) {
            System.out.println(entrada.getKey() + " - " + entrada.getValue().getSiglasEstado() + ": "
                    + entrada.getValue().getPopulacao());
        }

        System.out.println("--------------------");

        int menorPopulacao = Integer.MAX_VALUE;
        String estadoMenorPopulacao = "";
        for (Map.Entry<String, Siglas> regiao : estados.entrySet()) {
            if (regiao.getValue().getPopulacao() < menorPopulacao) {
                menorPopulacao = regiao.getValue().getPopulacao();
                estadoMenorPopulacao = regiao.getKey();
            }
        }

        System.out.println("Menor população: " + estadoMenorPopulacao + " - " + menorPopulacao);

        System.out.println("--------------------");

        int maiorPopulacao = Integer.MIN_VALUE;
        String estadoMaiorPopulacao = "";
        for (Map.Entry<String, Siglas> regiao : estados.entrySet()) {
            if (regiao.getValue().getPopulacao() > maiorPopulacao) {
                maiorPopulacao = regiao.getValue().getPopulacao();
                estadoMaiorPopulacao = regiao.getKey();
            }
        }

        System.out.println("Maior população: " + estadoMaiorPopulacao + " - " + maiorPopulacao);

        System.out.println("--------------------");

        int somaPopulacao = 0;
        int numeroEstados = estados.size();
        Iterator<Map.Entry<String, Siglas>> it = estados.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Siglas> entry = it.next();
            somaPopulacao += entry.getValue().getPopulacao();
        }

        double mediaPopulacao = (double) somaPopulacao / numeroEstados;

        System.out.println("Soma das populações: " + somaPopulacao);

        System.out.println("--------------------");

        System.out.println("Média: " + mediaPopulacao);

        System.out.println("--------------------");

        System.out.println("Limpeza");
        estados.clear();
        System.out.println(estados);

        System.out.println("--------------------");

        System.out.println("Verificação: " + estados.isEmpty());
    }
}