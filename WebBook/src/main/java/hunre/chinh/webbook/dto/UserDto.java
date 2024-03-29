package hunre.chinh.webbook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private Long id;
 //   @NotEmpty
    private String name;
//    @NotEmpty
    private String gender;
    private String birthday;
    private String address;
    private String phone;
//    @NotEmpty(message = "Email should not be empty")
//    @Email
    private String email;
//    @NotEmpty(message = "Password should not be empty")
    private String password;
    

}
