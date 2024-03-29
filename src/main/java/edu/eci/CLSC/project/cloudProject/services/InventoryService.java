package edu.eci.CLSC.project.cloudProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eci.CLSC.project.cloudProject.models.*;
import edu.eci.CLSC.project.cloudProject.repositories.InventoryRepository;
import edu.eci.CLSC.project.cloudProject.repositories.ProviderRepository;


@Service
public class InventoryService {
    
    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProviderRepository providerRepository;
}
