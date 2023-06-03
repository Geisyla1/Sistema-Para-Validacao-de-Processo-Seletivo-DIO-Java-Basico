import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        imprimiSelecaionados();
        String[] candidatos = {"Geisyla", "Luiza", "Bruna", "Rangel", "Beatriz"};
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuaTentando = !atendeu;
            if (continuaTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }
        } while (continuaTentando && tentativasRealizadas < 3);
        if (atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas);
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato);
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimiSelecaionados() {
        String[] candidatos = {"Geisyla", "Luiza", "Bruna", "Rangel", "Beatriz"};
        System.out.println("Imprimindo a lista de candidatos informado os elementos");

        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("O candidato de numero " + (i+1) + " de nome " + candidatos[i]);
        }
    }

    static void selecaoCandidatos() {
        System.out.println("Processo seletivo");
        String[] candidatos = {"Geisyla", "Luiza", "Bruna", "Rangel", "Beatriz", "Luna", "Luiz", "Angel"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        Double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {

            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("o candidato " + candidato + " solicitou este valor de salario " + salarioPretendido);
            System.out.println();

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato selecionado para a vaga e " + candidatos[candidatosSelecionados]);
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2100);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {

            System.out.println("Ligar para o candidato");

        } else if (salarioBase == salarioPretendido) {

            System.out.println("candidato aprovado");

        } else {

            System.out.println("Aguardando o resultado dos demais candidatos");

        }
    }
}