package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoContaCarlos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");

		EntityManager em = emf.createEntityManager();

		Conta contaDoCarlos = em.find(Conta.class, 1L);

		em.getTransaction().begin();

		contaDoCarlos.setSaldo(20.0);
		
		em.getTransaction().commit();

	}

}
