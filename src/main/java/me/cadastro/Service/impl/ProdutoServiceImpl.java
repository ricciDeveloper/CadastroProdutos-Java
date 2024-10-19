package me.cadastro.Service.impl;
import me.cadastro.Model.Produto;
import me.cadastro.Repository.ProdutoRepository;
import me.cadastro.Service.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProdutoServiceImpl implements ProdutoService {
	/*@Autowired
	private ProdutoRepository repository;
	*/
	private final ProdutoRepository repository;


	public ProdutoServiceImpl(ProdutoRepository repository) {
		this.repository = repository;
	}

	@Override
	public Produto salvarProduto(Produto produto) {
		return repository.save(produto);
	}

	@Override
	public void localizarProdutoPorId(Long id) {
		repository.findById(id);
	}

	@Override
	public Iterable<Produto> buscarTodosProdutos() {
		return repository.findAll();
	}

	@Override
	public void atualizarProdutos(Long id, Produto produto) {
		Optional<Produto> produtosBD = repository.findById(id);
		if(produtosBD.isPresent()){
			salvarProduto(produto);
		}
	}

	@Override
	public void deletarPorId(Long id) {
		repository.deleteById(id);
	}
}
