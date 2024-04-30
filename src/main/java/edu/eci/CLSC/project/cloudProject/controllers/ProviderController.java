package edu.eci.CLSC.project.cloudProject.controllers;

import edu.eci.CLSC.project.cloudProject.models.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.eci.CLSC.project.cloudProject.Exception.AccountException;
import edu.eci.CLSC.project.cloudProject.Exception.BankException;
import edu.eci.CLSC.project.cloudProject.Exception.ProviderException;
import edu.eci.CLSC.project.cloudProject.models.Account;
import edu.eci.CLSC.project.cloudProject.models.Bank;
import edu.eci.CLSC.project.cloudProject.models.Provider;
import edu.eci.CLSC.project.cloudProject.services.AccountService;
import edu.eci.CLSC.project.cloudProject.services.BankService;
import edu.eci.CLSC.project.cloudProject.services.ProviderService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @Autowired
    private BankService bankService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/{nit}")
    public ResponseEntity<Provider> getAProvider(@PathVariable String nit) {
        try {
            return ResponseEntity.ok().body(providerService.getProviderByNIT(nit));
        } catch (ProviderException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/transaction")
    public ResponseEntity<?> doTransaction(@RequestBody TransactionDto dta) {
        try {
            Bank bank = this.bankService.getBank(dta.getBank());
            Account account = this.accountService.getAccount(dta.getAccountNumber());
            Provider provider = this.providerService.getProviderByNIT(dta.getNit());
            if (bank != null && bank.getAccounts().contains(account)) {
                this.accountService.transaction(accountService.getAccount(dta.getAccountNumber()), provider.getAccount(),
                        dta.getAmount());
                return ResponseEntity.ok().build();
            } else{
                return new ResponseEntity<>("No se pudo realizar la transacción", HttpStatus.BAD_REQUEST);
            }

        } catch (BankException e) {
            return new ResponseEntity<>("Banco no encontrado", HttpStatus.NOT_FOUND);
        } catch (AccountException e) {
            return new ResponseEntity<>("Cuenta no encontrada", HttpStatus.NOT_FOUND);
        } catch (ProviderException e) {
            return new ResponseEntity<>("Proveedor no encontrado", HttpStatus.NOT_FOUND);
        }
    }

}
