package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");

		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setAgencia(123);
		conta.setNumero(25175);
		conta.setTitular("Marcia PJ");
		conta.setSaldo(100.0);

		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();

		em.close();		
		
		System.out.println("ID da conta da Márcia: " + conta.getId());
		conta.setSaldo(500.0);

		EntityManager em2 = emf.createEntityManager();
		

		em2.getTransaction().begin();

		em2.merge(conta);
		
		em2.getTransaction().commit();
		
		
		
	}

}
