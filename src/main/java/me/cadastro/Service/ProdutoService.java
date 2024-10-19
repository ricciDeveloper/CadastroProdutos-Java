package me.cadastro.Service;

import me.cadastro.Exceptions.PriceException;
import me.cadastro.Exceptions.ProductNullPointerException;
import me.cadastro.Model.Produto;
import me.cadastro.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository repository;

	public Produto save(Produto produto)throws Exception{
		if(produto.getNomeProduto() == null){
			throw new ProductNullPointerException();
		}
		if (produto.getPrecoProduto() <= 0){
			throw new PriceException();
		}
		return repository.save(produto);
	}

	public Produto findById(Long id){
		return repository.findById(id).orElse(null);
	}

	public List<Produto> findAll(){
		return repository.findAll();
	}

	public Produto deleteById(Long id){
		return repository.deleteById(id);
	}
}
