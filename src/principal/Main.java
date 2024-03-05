package principal;

import java.util.Scanner;

import controller.AlunoController;
import repositories.AlunoRepository;

public class Main {

	public static void main(String[] args) {

		AlunoController alunoController = new AlunoController();
		
		System.out.println("(1) - CADASTRAR ALUNO");
		System.out.println("(2) - ATUALIZAR ALUNO");
		System.out.println("(3) - EXCLUIR ALUNO");
		System.out.println("(4) - CONSULTAR ALUNO");

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Informe a Opção Desejada.....:");
		Integer opcao = Integer.parseInt(scanner.nextLine());
		
		switch (opcao) {
		case 1:
			alunoController.cadastroAluno();
		case 2:
			alunoController.atualizarAluno();
		case 3:
			alunoController.excluirAluno();
		case 4:
			alunoController.consultarAluno();
		default:
			System.out.println("OPÇÃO INVALIDA");
			break;
		}
		scanner.close();
	}

}
