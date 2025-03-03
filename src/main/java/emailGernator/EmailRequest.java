package emailGernator;

import lombok.Data;

import java.util.Collection;

@Data
public class EmailRequest {

    private String email;
    private String tone;

    public String getTone() {
        return tone;
    }
    public String getEmail(){
       return email;
    }
}
