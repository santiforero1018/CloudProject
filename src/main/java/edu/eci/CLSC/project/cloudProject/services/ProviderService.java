package edu.eci.CLSC.project.cloudProject.services;


import edu.eci.CLSC.project.cloudProject.Exception.ProviderException;
import edu.eci.CLSC.project.cloudProject.models.Provider;

public interface ProviderService {
    public Provider addProvide(Provider pr);

    public Provider updateProvider(String prName, Provider pr) throws ProviderException;

    public Provider getProvider(String name) throws ProviderException;

    public Provider getProviderByNIT(String nit) throws ProviderException;
}
