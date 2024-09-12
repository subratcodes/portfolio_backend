package portfolio.Response;
import java.net.http.HttpHeaders;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Setter
@Getter
@Builder
 public class ResponseTemplate{

  private  HttpStatus status;
  private  String error;
  private List<?> data;
  private HttpHeaders customHeader;

    public ResponseTemplate(HttpStatus status, String error, List<?> data, HttpHeaders header){
        this.status=status;
        this.error=error;
        this.data=data;
        this.customHeader=header;
    }


    public ResponseTemplate(HttpStatus status){
        this.status=status;
    }

     public ResponseTemplate(List<?>data, HttpStatus status) {
         this.data = data;
         this.status = status;
     }


}