package com.jamily.FastFood.api.controller;

import com.jamily.FastFood.domain.repository.ProdutoRepository;
import com.jamily.FastFood.domain.model.Produto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jamily
 */
@RestController
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @GetMapping("/produto")
    public List<Produto> listar(){
        return produtoRepository.findAll();
    }
    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> listarId(@PathVariable Long id){
        Optional <Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
