package com.jamily.FastFood.api.controller;

import com.jamily.FastFood.domain.model.Pedido;
import com.jamily.FastFood.domain.repository.PedidoRepository;
import com.jamily.FastFood.domain.service.PedidoService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jamily
 */
@RestController
public class PedidoController {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private PedidoService pedidoService;
    
    @GetMapping("/pedido")
    public List<Pedido> listar(){
        return pedidoRepository.findAll();
    }
    
    @PostMapping("/pedido")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido criar(@RequestBody Pedido pedido){
        return pedidoService.criar(pedido);
    }
    
    @PutMapping("/pedido/preparando/{pedidoid}")
    public ResponseEntity<Pedido> preparando(@Valid @PathVariable Long pedidoid){
        if(!pedidoRepository.existsById(pedidoid)){
            return ResponseEntity.notFound().build();
        }
        return pedidoService.prepaprando(pedidoid);
    }
  
    @PutMapping("/pedido/entregue/{pedidoid}")
    public ResponseEntity<Pedido> entregue(@Valid @PathVariable Long pedidoid){
        if(!pedidoRepository.existsById(pedidoid)){
            return ResponseEntity.notFound().build();
        }
        return pedidoService.entregue(pedidoid);
    }
    
    @DeleteMapping("/{pedidoid}")
    public ResponseEntity<Void> excluir (@PathVariable Long pedidoid){
        if (!pedidoRepository.existsById(pedidoid)) {
            return ResponseEntity.notFound().build();
        }
        
        pedidoRepository.deleteById(pedidoid);
        return ResponseEntity.noContent().build();
    }
}
