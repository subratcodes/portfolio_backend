package portfolio.Response;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.http.HttpStatus;

 public class ResponseTemplate{

  private  HttpStatus status;
  private  String error;
  private  List<?> data;
  private HttpHeaders customHeader;

    public ResponseTemplate(HttpStatus status, String error, List<?> data, HttpHeaders header){
        this.status=status;
        this.error=error;
        this.data=data;
        this.customHeader=header;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public HttpHeaders getCustomHeader() {
        return customHeader;
    }

    public void setCustomHeader(HttpHeaders customHeader) {
        this.customHeader = customHeader;
    }




    

   

    

}