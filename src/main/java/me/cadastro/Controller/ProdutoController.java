package me.cadastro.Controller;

import me.cadastro.Exceptions.ProductNameEmptyException;
import me.cadastro.Model.Produto;
import me.cadastro.Service.ProdutoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService service;


	//TODO: finalizar tratamento de exceções para melhorar as regras de negocio da API


	//Método post, para enviar
		//End point /produto/save
	@PostMapping(value = "/save")
		//Entidade de resposta								//A requisição precisa de um corpo
	public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) throws Exception {
		if(produto.getNomeProduto().isEmpty()) {
			throw new ProductNameEmptyException("O nome do produto não pode estar vazio.");
		}
		produto = service.salvarProduto(produto);
		return ResponseEntity.ok().body(produto);
	}
	//Método get, solicitar um  corpo
	@GetMapping(value = "/buscarProduto")
												//requisição de parameters de busca
	public ResponseEntity<Produto> buscarProduto(@RequestParam Long id){
		Produto produto = service.localizarProdutoPorId(id);
		return ResponseEntity.ok().body(produto);
	}
	//Entidade de resposta, tipada em uma Lista do tipo produto.
		//Onde retorna todos os produtos.
	@GetMapping(value = "/buscarTodosProdutos")
	public ResponseEntity<List<Produto>> buscarTodosProdutos(){
		List<Produto> produto = service.buscarTodosProdutos();
		return ResponseEntity.ok().body(produto);
	}
}
