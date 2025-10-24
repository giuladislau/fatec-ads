import java.util.ArrayDeque;
import java.util.Random;

public class Supermercado {
    public static void main(String[] args) {
        ArrayDeque<Cliente> fila = new ArrayDeque<>();
        
        fila.add(new Cliente("Ana", 10, 0));
        fila.add(new Cliente("João", 10, 5));
        fila.add(new Cliente("Maria", 10, 10));
        fila.add(new Cliente("José", 10, 15));
        fila.add(new Cliente("Antonio", 10, 20));
        fila.add(new Cliente("Marcos", 10, 25));
        fila.add(new Cliente("Solange", 10, 30));
        
        Random random = new Random();
        int horaAtual = 10;
        int minutoAtual = 0;
        int totalMinutosAtendimento = 0;
        double totalGasto = 0.0;
        
        while (!fila.isEmpty()) {
            Cliente cliente = fila.poll();
            
            cliente.setHoraatendimento(horaAtual);
            cliente.setMinutoatendimento(minutoAtual);
            
            double valorGasto = 50.0 + (random.nextDouble() * 150.0);
            cliente.setValorgasto(valorGasto);
            
            int minutosAtendimento = 5 + random.nextInt(11);
            
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("Chegada: " + cliente.getHorachegada() + ":" + 
                             String.format("%02d", cliente.getMinutochegada()));
            System.out.println("Atendimento: " + cliente.getHoraatendimento() + ":" + 
                             String.format("%02d", cliente.getMinutoatendimento()));
            System.out.println("Valor gasto: R$ " + String.format("%.2f", cliente.getValorgasto()));
            System.out.println("Minutos de atendimento: " + minutosAtendimento);
            System.out.println();
            
            totalMinutosAtendimento += minutosAtendimento;
            totalGasto += valorGasto;
            
            minutoAtual += minutosAtendimento;
            if (minutoAtual >= 60) {
                horaAtual += minutoAtual / 60;
                minutoAtual = minutoAtual % 60;
            }
        }
        
        System.out.println("=== RESUMO ===");
        System.out.println("Total de minutos gastos em atendimentos: " + totalMinutosAtendimento);
        System.out.println("Total gasto por todos os clientes: R$ " + String.format("%.2f", totalGasto));
    }
}