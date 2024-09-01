package portfolio.beans;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Coach {

    String name;
    String lName;

    public Coach(String name, String lName){

        this.name=name;
        this.lName=lName;

        log.info("Coach constructor called");

    }
    @PostConstruct
    public void getFunction(){
        System.out.println(" Post Construct function gets called");

    }

    @PreDestroy
    public void function(){
        System.out.println();
    }
    
}
