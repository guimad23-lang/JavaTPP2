package TPP2;

// Desenvolvido por Gael Felix e Guilherme Francisco
// Crie a classe ConsultaAgendada conforme especificado (2,0):

import java.util.Scanner;

public class ConsultaAgendada{
	private Data data;
	private Hora hora;
	private String nomePaciente;
	private static int quantidade;
	private String nomeMedico;

	public ConsultaAgendada(){
		data = new Data();
		hora = new Hora();
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o nome do paciente: ");
		nomePaciente = leitor.next();
		System.out.println("Insira o nome do médico: ");
		nomeMedico = leitor.next();

		quantidade++;
	}   
	
	public ConsultaAgendada(int h, int mi, int s, int d, int me, int a, String p, String m){
		data = new Data(d, me, a);
		hora = new Hora(h, mi, s);
		nomePaciente = p;
		nomeMedico = m;

		quantidade++;		
	}

	public ConsultaAgendada(Data d, Hora h, String p, String m){
		data = d;
		hora = h;
		nomePaciente = p;
		nomeMedico = m;
		
		quantidade++;
	}

	// --- Setters ---

	public void setData(int a, int b, int c){
		data.setDia(a);
		data.setMes(b);
		data.setAno(c); 
	}
	public void setData(){
		data.setDia();
		data.setMes();
		data.setAno();
	}
	public void setHora(int a, int b, int c){
		hora.setHor(a);
		hora.setMin(b);
		hora.setSeg(c); 
	}
	public void setHora(){
		hora.setHor();
		hora.setMin();
		hora.setSeg();
	}
	public void setNomePaciente(String p){
		nomePaciente = p;
	}
	public void setNomePaciente(){
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o nome do paciente: ");
		nomePaciente = leitor.next();
	}
	public void setNomeMedico(String m){
		nomeMedico = m;
	}
	public void setNomeMedico(){
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o nome do médico: ");
		nomeMedico = leitor.next();
	}

	// --- Getters ---

	public int getAmostra(){
		return quantidade;
	}
	public String getData(){
		return data.mostra1();
	}
	public String getHora(){
		return hora.getHora1();
	}
	public String getNomePaciente(){
		return nomePaciente;
	}
	public String getNomeMedico(){
		return nomeMedico;
	}
}
