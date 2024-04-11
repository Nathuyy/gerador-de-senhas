import java.security.SecureRandom; //gera numeros seguros aleatorios
import java.util.Scanner;
public class geradorDeSenhas {

    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
   
    

    public static String gerarSenha(int tamanho) {
        SecureRandom aleatorio = new SecureRandom();
        StringBuilder senha = new StringBuilder(tamanho);
    

    for (int i = 0; i < tamanho; i++) { 
        int indice = aleatorio.nextInt(CARACTERES.length());
        senha.append(CARACTERES.charAt(indice));
    }
        return senha.toString();
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Insira o tamanho da sua senha: ");
        int tamanho = tratamentoDeTamanho(leitor);

        String senhaGerada = gerarSenha(tamanho);

        System.out.println("Senha gerada: " + senhaGerada);

        leitor.close(); 
    }
    
    public static int tratamentoDeTamanho(Scanner leitor) {
        while (true) {
            try {
                int tamanho = Integer.parseInt(leitor.nextLine());
                return tamanho;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            }
        }
    }
}