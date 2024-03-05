package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entities.Aluno;
import factories.ConnectionFactory;

public class AlunoRepository {

	public void cadastrar(Aluno aluno) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("insert into aluno(id, nome, matricula, cpf) values(?,?,?,?)");

		statement.setInt(1, aluno.getId());
		statement.setString(2, aluno.getNome());
		statement.setString(3, aluno.getMatricula());
		statement.setString(4, aluno.getCpf());
		statement.execute();

		connection.close();
	}

	public void editar(Aluno aluno) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("update aluno set id=?, nome=?, email=?, cpf=?");

		statement.setInt(1, aluno.getId());
		statement.setString(2, aluno.getNome());
		statement.setString(3, aluno.getMatricula());
		statement.setString(4, aluno.getCpf());
		statement.execute();

		connection.close();
	}

	public void excluir(Aluno aluno) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("delete from aluno where id=?");

		statement.setInt(1, aluno.getId());
		statement.execute();

		statement.close();

	}

	public Aluno obterPorNome(Nome nome) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("select from aluno where nome=?");

		statement.setInt(1, nome);
		ResultSet resultSet = statement.executeQuery();

		Aluno aluno = null;

		if (resultSet.next())	;
		{

			aluno = new Aluno();
			aluno.setId(resultSet.getInt("id"));
			aluno.setNome(resultSet.getString("nome"));
			aluno.setMatricula(resultSet.getString("matricula"));
			aluno.setCpf(resultSet.getString("cpf"));

		}

		connection.close();
		return aluno;

	}

	public List<Aluno> obterTodos() throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from aluno order by nome");

		ResultSet resultSet = statement.executeQuery();

		List<Aluno> lista = new ArrayList<Aluno>();

		while (resultSet.next()) {

			Aluno aluno = new Aluno();
			aluno.setId(resultSet.getInt("id"));
			aluno.setNome(resultSet.getString("nome"));
			aluno.setMatricula(resultSet.getString("matricula"));
			aluno.setCpf(resultSet.getString("cpf"));

			lista.add(aluno);
		}
		connection.close();
		return lista;
	}

}
