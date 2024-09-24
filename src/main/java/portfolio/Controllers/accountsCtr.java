package portfolio.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;

import portfolio.Exceptions.NoDataFound;
import portfolio.Models.Externals.accounts;
import portfolio.Response.ResponseTemplate;
import portfolio.Service.accountsService.accountServiceContract;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/")
public class accountsCtr {


    @Autowired
    accountServiceContract accountService;

    
    @GetMapping("getAllAccounts")
    public Page<accounts> getAccounts(@RequestParam("page") int pageNo){
      return accountService.findAll(pageNo);
    }



    @GetMapping("/account/{id}")
    public ResponseEntity<ResponseTemplate> getMethodName(@PathVariable String id) throws Exception {

        Optional<accounts> account=accountService.findById(id);


        if(!account.isPresent()){
          ResponseTemplate template=ResponseTemplate.builder()
          .status(HttpStatus.OK).build();
          return ResponseEntity.ok(template);
        }


        ResponseTemplate template=ResponseTemplate.builder()
        .status(HttpStatus.OK).data(Arrays.asList(account.get())).build();
        return ResponseEntity.ok(template);
        
      
    }
    



    
}
