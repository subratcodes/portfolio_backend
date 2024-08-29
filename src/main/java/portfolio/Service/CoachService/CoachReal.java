package portfolio.Service.CoachService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class CoachReal implements CoachServiceContract {

    public CoachReal(){
    
        log.info("Coach Data being called");
    }

    @Override
    public String getData() {
        // TODO Auto-generated method stub
        return new String("This is a real data");
    }


}
