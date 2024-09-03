package portfolio.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import portfolio.Models.Externals.accounts;
import portfolio.Service.accountsService.accountServiceContract;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/accounts/v1")
public class accountsCtr {


    @Autowired
    accountServiceContract accountService;

    
    @GetMapping("/getAllAccounts")
    public Page<accounts> getAccounts(@RequestParam("page") int pageNo){
      return accountService.findAll(pageNo);
    }








    
}
