package edu.eci.CLSC.project.cloudProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eci.CLSC.project.cloudProject.models.*;
import edu.eci.CLSC.project.cloudProject.repositories.ProviderRepository;

@Service
public class ProviderService {
    
    @Autowired
    private ProviderRepository providerRepository;

    public Provider addProvide(Provider pr){
        return this.providerRepository.save(pr);
    }

    public Provider updateProvider(Provider pr){
        if(this.providerRepository.existsById(pr.getId())) return this.providerRepository.save(pr);

        return null;
    }

    public Provider getProvider(String name){
        return this.providerRepository.findByName(name);
    }
}
