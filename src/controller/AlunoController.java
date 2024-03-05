package controller;

import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import repositories.AlunoRepository;

public class AlunoController {

	public void cadastroAluno() {

		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("CADASTRAMENTO DE ALUNOS");

			System.out.println("Id.........:");
			Integer id = Integer.parseInt(scanner.nextLine());

			System.out.println("Nome.......:");
			String nome = scanner.nextLine();

			System.out.println("Matricula..:");
			String matricula = scanner.nextLine();

			System.out.println("Cpf........:");
			String cpf = scanner.nextLine();

			Aluno aluno = new Aluno(id, nome, matricula, cpf);

			AlunoRepository alunoRepository = new AlunoRepository();
			alunoRepository.cadastrar(aluno);

			System.out.println("ALUNO CADASTRADO COM SUCESSO");

		} catch (Exception e) {
			System.out.println("ERRO NO CADASTRO");
			System.err.println(e.getMessage());
		}
		scanner.close();
	}

	public void consultarAluno() {

		try {
			System.out.println("CONSULTA DE ALUNOS");

			AlunoRepository alunoRepository = new AlunoRepository();
			List<Aluno> lista = alunoRepository.obterTodos();

			for (Aluno aluno : lista) {

				System.out.println("Id.........:" + aluno.getId());
				System.out.println("Nome.......:" + aluno.getNome());
				System.out.println("Matricula..:" + aluno.getMatricula());
				System.out.println("Cpf........:" + aluno.getCpf());
				System.out.println("\n");
			}
		} catch (Exception e) {
			System.out.println("FALHA AO ENCONTRAR ALUNO");
			System.out.println(e.getMessage());
		}

	}

	public void atualizarAluno() {

		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("***ATUALIZAÇÃO DE ALUNOS***");

			System.out.println("Nome do Aluno.....:");
			String nome = (scanner.nextLine());

			AlunoRepository alunoRepository = new AlunoRepository();
			Aluno aluno = alunoRepository.obterPorNome(nome);

			if (aluno != null) {

				System.out.println("Id do Aluno............:");
				// Integer id = Integer.parseInt(scanner.nextLine());
				aluno.setId(Integer.parseInt(scanner.nextLine()));

				System.out.println("Nome do Aluno..........:");
				// String nome = scanner.nextLine();
				aluno.setNome(scanner.nextLine());

				System.out.println("Matricula do Aluno.....:");
				// String matricula = scanner.nextLine();
				aluno.setMatricula(scanner.nextLine());

				System.out.println("Cpf do Aluno...........:");
				// String cpf = scanner.nextLine();
				aluno.setCpf(scanner.nextLine());

				System.out.println("ALUNO CADASTRADO COM SUCESSO");
			} else {
				System.out.println("ALUNO NÃO ENCONTRADO");
			}

		} catch (Exception e) {
			System.out.println("ERRO AO ATUALIZAR ALUNO");
		}
		scanner.close();

	}

	public void excluirAluno() {

		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("***EXCLUIR ALUNOS***");

			System.out.println("Informe o Nome do Aluno.....:");
			String nome = scanner.nextLine();

			AlunoRepository alunoRepository = new AlunoRepository();
			Aluno aluno = alunoRepository.obterPorNome(nome);

			if (aluno != null) {
				System.out.println("Id do Aluno............:");
				aluno.setId(Integer.parseInt(scanner.nextLine()));

				System.out.println("Nome do Aluno..........:");
				aluno.setNome(scanner.nextLine());

				System.out.println("Matricula do Aluno.....:");
				aluno.setMatricula(scanner.nextLine());

				System.out.println("Cpf do Aluno...........:");
				aluno.setCpf(scanner.nextLine());

				alunoRepository.excluir(aluno);

				System.out.println("ALUNO EXLUIDO COM SUCESSO");
			} else {
				System.out.println("ALUNO NÃO ENCONTRADO");
			}

		} catch (Exception e) {
			System.out.println("ERRO AO EXLUIR ALUNO");
			System.out.println(e.getMessage());
		}
		scanner.close();

	}
}
