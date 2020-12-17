package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");

		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setAgencia(123);
		conta.setNumero(45632);
		conta.setTitular("Carlos");

		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();

		emf.close();

	}

}
