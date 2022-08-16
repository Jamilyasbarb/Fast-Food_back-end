package com.jamily.FastFood.domain.repository;

import com.jamily.FastFood.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jamily
 */

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}
