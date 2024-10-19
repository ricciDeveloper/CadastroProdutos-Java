package me.cadastro.Service;

import me.cadastro.Model.Produto;
import org.springframework.stereotype.Service;

@Service
public interface ProdutoService {

	Produto salvarProduto(Produto produto);
	void localizarProdutoPorId(Long id);
	Iterable<Produto> buscarTodosProdutos();
	void atualizarProdutos(Long id, Produto produto);
	void deletarPorId(Long id);


}
