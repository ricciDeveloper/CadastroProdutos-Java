package me.cadastro.Service;

import me.cadastro.Model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProdutoService {

	Produto salvarProduto(Produto produto);
	Produto localizarProdutoPorId(Long id);
	List<Produto> buscarTodosProdutos();
	void atualizarProdutos(Long id, Produto produto);
	void deletarPorId(Long id);


}
