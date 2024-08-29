package portfolio.Service.CoachService;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Profile("mock")
@Service
@Slf4j
@Primary
public class CoachMock implements CoachServiceContract {

    public CoachMock(){
      log.info("Coach mock is being called");  
    }


    @Override
    public String getData() {
        // TODO Auto-generated method stub
        return new String("Mock data being called");
    }
   



}
