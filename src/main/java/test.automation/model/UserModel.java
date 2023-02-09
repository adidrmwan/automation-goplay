package test.automation.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter(onMethod_={@Synchronized}) @Setter(onMethod_={@Synchronized})
@Component("test.automation.model.UserModel")
public class UserModel {
    private String email;
    private String password;
    private String phone;
}