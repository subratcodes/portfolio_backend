package portfolio.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.lang.String;


@Scope("prototype")
public class Coach {

    String name;
    String lName;

    public Coach(String name, String lName){

        this.name=name;
        this.lName=lName;
        System.out.println("Coach bean constructor called.");
    }

   
}
