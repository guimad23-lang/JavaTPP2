package TPP2;

public class Exercicio3{
	public static void main(String[] args){

		ConsultaAgendada p1 = new ConsultaAgendada(14, 45, 30, 26, 6, 2026, "Gael", "Guilherme");		

		System.out.println("Dados da consulta p1: ");
		System.out.println("Paciente: " + p1.getNomePaciente());
		System.out.println("Dia " + p1.getData() + " às " + p1.getHora());
		System.out.println("Médico: " + p1.getNomeMedico());
		System.out.println();

		System.out.println("----- Inserindo os dados da consulta p2 -----");

		ConsultaAgendada p2 = new ConsultaAgendada();
	
		System.out.println("Dados da consulta p2: ");
		System.out.println("Paciente: " + p2.getNomePaciente());
		System.out.println("Dia " + p2.getData() + " às " + p2.getHora());
		System.out.println("Médico: " + p2.getNomeMedico());
		System.out.println();

		System.out.println("----- Atualizando os dados da consulta p1 -----");
	
		p1.setNomePaciente();
		p1.setData();
		p1.setHora();
		p1.setNomeMedico();
		System.out.println();

		System.out.println("Dados atualizados da consulta p1:");
		System.out.println("Paciente: " + p1.getNomePaciente());
		System.out.println("Dia " + p1.getData() + " às " + p1.getHora());
		System.out.println("Médico: " + p1.getNomeMedico());
		System.out.println();

		System.out.println("Total de consultas: " + p2.getAmostra());

	}
}