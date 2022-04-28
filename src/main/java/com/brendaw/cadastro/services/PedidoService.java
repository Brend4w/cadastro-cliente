package com.brendaw.cadastro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brendaw.cadastro.domain.Pedido;
import com.brendaw.cadastro.repositories.PedidoRepository;
import com.brendaw.cadastro.services.exceptions.ObjectNotFoundException;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj= repo.findById(id);	
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id+ ", Tipo: "+ Pedido.class.getName()));
	}
	
}
