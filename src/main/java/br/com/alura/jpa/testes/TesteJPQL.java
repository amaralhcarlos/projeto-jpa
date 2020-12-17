package br.com.alura.jpa.testes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(2L);

		//Passando um objeto para comparação
		String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor asc";
		
		//Passando um valor diretamente (Não adequado)
		//String jpql = "select m from Movimentacao m where m.conta.id = 2";
				
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		//Query sem tipagem
		//Query query = em.createQuery(jpql);
		
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("pConta", conta);
		
		
		List<Movimentacao> movimentacoes = query.getResultList();
		
		movimentacoes.forEach(System.out::println);		

	}

}
