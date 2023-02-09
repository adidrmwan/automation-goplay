package test.automation.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import test.automation.model.UserModel;

import java.util.HashMap;

@Data
@Configuration
@EnableConfigurationProperties({
        UserProperties.class
})
@ConfigurationProperties(prefix = "user")
public class UserProperties {
    private UserModel invalid;
    private UserModel not_registered;
    private UserModel none;

    public UserModel getUser(String type) {

        UserModel user;
        switch (type.toLowerCase()) {
            case "invalid":
                user = this.invalid;
                break;
            case "not_registered":
                user = this.not_registered;
                break;
            case "none":
                user = this.none;
                break;
            default: user = UserModel.builder().email(type).build();
        }

        return user;
    }
}
