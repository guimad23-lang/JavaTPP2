package TPP2;

// Desenvolvido por Gael Felix e Guilherme Francisco

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Date;
import java.text.DateFormat;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    // --- Métodos Auxiliares Internos ---
    private boolean verificaBissexto(int anoCheck) {
        return (anoCheck % 4 == 0 && anoCheck % 100 != 0) || (anoCheck % 400 == 0);
    }

    private boolean isDataValida(int d, int m, int a) {
        if (a < 1 || m < 1 || m > 12 || d < 1) return false;
        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (verificaBissexto(a)) diasPorMes[2] = 29; // Fevereiro em ano bissexto
        return d <= diasPorMes[m];
    }

    // --- Construtores ---
    public Data() {
        Scanner leitor = new Scanner(System.in);
        boolean valido = false;
        while (!valido) {
            try {
                System.out.println("Digite o dia: "); int d = leitor.nextInt();
                System.out.println("Digite o mês: "); int m = leitor.nextInt();
                System.out.println("Digite o ano: "); int a = leitor.nextInt();
                
                if (isDataValida(d, m, a)) {
                    this.dia = d; 
                    this.mes = m; 
                    this.ano = a;
                    valido = true;
                } else {
                    System.out.println("Data inválida! Por favor, redigite.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Digite apenas números inteiros.");
                leitor.nextLine();
            }
        }
    }

    public Data(int dia, int mes, int ano) {
        if (isDataValida(dia, mes, ano)) {
            this.dia = dia; 
            this.mes = mes; 
            this.ano = ano;
        } else {
            System.out.println("Valores inválidos no construtor. Setando data padrão: 01/01/1900");
            this.dia = 1; 
            this.mes = 1; 
            this.ano = 1900;
        }
    }

    // --- Getters (Padrão UML) ---
    public int getDia() { 
        return this.dia; 
    }
    
    public int getMes() { 
        return this.mes; 
    }
    
    public int getAno() { 
        return this.ano; 
    }

    // --- Setters (Padrão UML - Com parâmetros) ---
    public void setDia(int dia) { 
        if (isDataValida(dia, this.mes, this.ano)) {
            this.dia = dia; 
        } else {
            System.out.println("Dia inválido para o mês/ano atual.");
        }
    }
    
    public void setMes(int mes) { 
        if (isDataValida(this.dia, mes, this.ano)) {
            this.mes = mes; 
        } else {
            System.out.println("Mês inválido para o dia/ano atual.");
        }
    }
    
    public void setAno(int ano) { 
        if (isDataValida(this.dia, this.mes, ano)) {
            this.ano = ano; 
        } else {
            System.out.println("Ano inválido para a data atual.");
        }
    }

    // --- Setters (Sobrecarga - Sem parâmetros / Interativos) ---
    public void setDia() {
        Scanner leitor = new Scanner(System.in);
        boolean valido = false;
        while (!valido) {
            try {
                System.out.println("Digite o novo dia: ");
                int d = leitor.nextInt();
                if (isDataValida(d, this.mes, this.ano)) {
                    this.dia = d;
                    valido = true;
                } else {
                    System.out.println("Dia inválido para o mês/ano atual. Redigite.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro de entrada."); leitor.nextLine();
            }
        }
    }

    public void setMes() {
        Scanner leitor = new Scanner(System.in);
        boolean valido = false;
        while (!valido) {
            try {
                System.out.println("Digite o novo mês: ");
                int m = leitor.nextInt();
                if (isDataValida(this.dia, m, this.ano)) {
                    this.mes = m;
                    valido = true;
                } else {
                    System.out.println("Mês inválido para o dia/ano atual. Redigite.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro de entrada."); leitor.nextLine();
            }
        }
    }

    public void setAno() {
        Scanner leitor = new Scanner(System.in);
        boolean valido = false;
        while (!valido) {
            try {
                System.out.println("Digite o novo ano: ");
                int a = leitor.nextInt();
                if (isDataValida(this.dia, this.mes, a)) {
                    this.ano = a;
                    valido = true;
                } else {
                    System.out.println("Ano inválido para a data atual. Redigite.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro de entrada."); leitor.nextLine();
            }
        }
    }

    // --- Métodos de Formatação ---
    public String mostra1() {
        return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
    }

    public String mostra2() {
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                          "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        return String.format("%02d/%s/%04d", this.dia, meses[this.mes - 1], this.ano);
    }

    // --- Lógicas de Negócio ---
    public boolean bissexto() {
        return verificaBissexto(this.ano);
    }

    public int diasTranscorridos() {
        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (bissexto()) diasPorMes[2] = 29;

        int diasTotais = 0;
        for (int i = 1; i < this.mes; i++) {
            diasTotais += diasPorMes[i];
        }
        diasTotais += this.dia;
        return diasTotais;
    }

    public void apresentaDataAtual() {
        Date hoje = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Data Atual do Sistema: " + df.format(hoje));
    }
}
