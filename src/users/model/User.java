package users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String uuid;
    private String name;
    private String email;
    private String password;
    private Date cretedDate;
    private Boolean isDeleted;
}
