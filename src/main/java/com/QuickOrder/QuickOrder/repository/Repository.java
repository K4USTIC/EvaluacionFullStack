package com.QuickOrder.QuickOrder.repository;

import com.QuickOrder.QuickOrder.model.QuickOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<QuickOrderModel, Long> {

}

