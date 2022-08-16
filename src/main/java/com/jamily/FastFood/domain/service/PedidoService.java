package com.jamily.FastFood.domain.service;

import com.jamily.FastFood.domain.model.Pedido;
import com.jamily.FastFood.domain.model.StatusPedido;
import com.jamily.FastFood.domain.repository.PedidoRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jamily
 */
@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    public Pedido criar(Pedido pedido){
        pedido.setData_hora_pedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.CONFIRMADO);
        
        return pedidoRepository.save(pedido);
    }

    public ResponseEntity<Pedido> prepaprando(Long pedidoid) {
        Optional<Pedido> pedido = pedidoRepository.findById(pedidoid);
        pedido.get().setStatus(StatusPedido.PREPARANDO);
        pedido.get().setData_hora_entrega(LocalDateTime.now());
        
        pedidoRepository.save(pedido.get());
        return ResponseEntity.ok(pedido.get());
    }
    public ResponseEntity<Pedido> entregue(Long pedidoid) {
        Optional<Pedido> pedido = pedidoRepository.findById(pedidoid);
        pedido.get().setStatus(StatusPedido.ENTREGUE);
        pedido.get().setData_hora_entrega(LocalDateTime.now());
        
        pedidoRepository.save(pedido.get());
        return ResponseEntity.ok(pedido.get());
    }
}
