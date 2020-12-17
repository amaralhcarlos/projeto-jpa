package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
		
		Categoria categoriaUm = new Categoria("Viagem");
		
		Categoria categoriaDois = new Categoria("Negócios");
		
		Conta conta = new Conta();
		conta.setId(2L);
		
		
		Movimentacao movimentacaoUm = new Movimentacao();
		movimentacaoUm.setDescricao("Viagem à SP");
		movimentacaoUm.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacaoUm.setData(LocalDateTime.now());
		movimentacaoUm.setValor(new BigDecimal(300.0));
		movimentacaoUm.setCategorias(Arrays.asList(categoriaUm, categoriaDois));
		movimentacaoUm.setConta(conta);

		Movimentacao movimentacaoDois = new Movimentacao();
		movimentacaoDois.setDescricao("Viagem à RJ");
		movimentacaoDois.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacaoDois.setData(LocalDateTime.now());
		movimentacaoDois.setValor(new BigDecimal(400.0));
		movimentacaoDois.setCategorias(Arrays.asList(categoriaUm, categoriaDois));
		movimentacaoDois.setConta(conta);
		
		
		
		EntityManagerFactory efm = Persistence.createEntityManagerFactory("contas");
		EntityManager em = efm.createEntityManager();
				
		em.getTransaction().begin();
		
		em.persist(categoriaUm);
		em.persist(categoriaDois);
		em.persist(movimentacaoUm);
		em.persist(movimentacaoDois);
		
		em.getTransaction().commit();
		em.close();
		
	}
}
