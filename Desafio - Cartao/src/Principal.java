import br.com.alura.Model.Cartao;
import br.com.alura.Model.ListaDeCompras;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o limite do cartão: ");
        double limite = sc.nextDouble();
        Cartao cartao = new Cartao(limite);

        int fim = 1;
        while(fim != 0){
            System.out.println("Digite a descrição da compra: ");
            String descricao = sc.next();

            System.out.println("Digite o valor da compra: ");
            double valor = sc.nextDouble();

            ListaDeCompras compra = new ListaDeCompras(descricao, valor);
            boolean compraRealizada = cartao.debitaValor(compra);

            if (compraRealizada){
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                fim = sc.nextInt();
            }
            else {
                System.out.println("Saldo insuficiente!");
                fim = 0;
            }
        }

        System.out.println("*********************************");
        System.out.println("COMPRAS REALIZADAS: \n");

        Collections.sort(cartao.getCompras());
        for (ListaDeCompras compras : cartao.getCompras()){
            System.out.println(compras.getDescricao() + " - " + compras.getValor());
        }
        System.out.println("\n*********************************");
        System.out.println("\nSaldo do cartão: " + cartao.getSaldo());

    }

}
