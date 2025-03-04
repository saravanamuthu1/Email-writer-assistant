package emailGernator;
import lombok.Data;
@Data
public class EmailRequest {

    private String email;
    private String tone;

    public EmailRequest(String email, String tone) {
        this.email = email;
        this.tone = tone;
    }

    public String getTone() {
        return tone;
    }
    public String getEmail(){
       return email;
    }
}
