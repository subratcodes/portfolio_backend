package portfolio.Models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class shipwrecks {

    @Id
    private String _id;
    private String recrd;
    private String vesslTerms;
    private String feature_type;
    private String chart;
    private Integer latdec;
    private Integer londec;
    private String gp_quality;
    private Integer depth;
    private String sounding_type;
    private String history;
    private String quasou;
    private String watlev;
    private Integer[] coordinates;
    
}
