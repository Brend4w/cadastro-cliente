package com.brendaw.cadastro;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brendaw.cadastro.domain.Categoria;
import com.brendaw.cadastro.domain.Cidade;
import com.brendaw.cadastro.domain.Cliente;
import com.brendaw.cadastro.domain.Endereco;
import com.brendaw.cadastro.domain.Estado;
import com.brendaw.cadastro.domain.Produto;
import com.brendaw.cadastro.domain.enums.TipoCliente;
import com.brendaw.cadastro.repositories.CategoriaRepository;
import com.brendaw.cadastro.repositories.CidadeRepository;
import com.brendaw.cadastro.repositories.ClienteRepository;
import com.brendaw.cadastro.repositories.EnderecoRepository;
import com.brendaw.cadastro.repositories.EstadoRepository;
import com.brendaw.cadastro.repositories.ProdutoRepository;

@SpringBootApplication
public class CadastroApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(CadastroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

		Estado est1 = new Estado (null, "Minas Gerais");
		Estado est2 = new Estado (null, "São Paulo");
		
		Cidade c1 = new Cidade (null, "Uberlândia", est1);
		Cidade c2 = new Cidade (null, "São Paulo", est2);
		Cidade c3 = new Cidade (null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));

		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente (null, "MAria Silva", "mariasilva@gmail.com", "11942399955", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("23232324", "2325425424"));
		
		Endereco e1 = new Endereco (null, "Rua Choca Barrada", "440","Casa", "Jardim", "86703527", cli1, c1);
		Endereco e2 = new Endereco (null, "Avenida Matos", "880","Casa", "Centro", "86703335", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}

}
