package edu.eci.CLSC.project.cloudProject.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.CLSC.project.cloudProject.Exception.MessageErros;
import edu.eci.CLSC.project.cloudProject.Exception.ProviderException;
import edu.eci.CLSC.project.cloudProject.models.*;
import edu.eci.CLSC.project.cloudProject.repositories.ProviderRepository;
import edu.eci.CLSC.project.cloudProject.services.ProviderService;

@Service
public class ProviderServiceMap implements ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public Provider addProvide(Provider pr) {
        return this.providerRepository.save(pr);
    }

    @Override
    public Provider updateProvider(String prName,Provider pr) throws ProviderException{
        if (this.providerRepository.findByName(prName).isPresent()){
            return this.providerRepository.save(pr);
        } else {
            throw new ProviderException(MessageErros.NOT_FOUND_PROVIDER.getMessageError());
        }

    }

    @Override
    public Provider getProvider(String name) throws ProviderException {
        return this.providerRepository.findByName(name)
                .orElseThrow(() -> new ProviderException(MessageErros.NOT_FOUND_PROVIDER.getMessageError()));
    }

    @Override
    public Provider getProviderByNIT(String nit) throws ProviderException{
        return this.providerRepository.findByNit(nit)
                .orElseThrow(() -> new ProviderException(MessageErros.NOT_FOUND_PROVIDER.getMessageError()));
    }
}
