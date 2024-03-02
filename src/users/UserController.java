package users;

import org.nocrala.tools.texttablefmt.BorderStyle;

import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Scanner;

public class UserController {
    private final UserService userService  = new UserServiceImp();
    public void getAllUsers(){
        Table table = new Table(5, BorderStyle.UNICODE_BOX, ShownBorders.ALL,false);
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center,
                CellStyle.AbbreviationStyle.crop,
                CellStyle.NullStyle.emptyString);
        String[] cols = new String[]{"UUID","NAME","EMAIL","CREATED DATE","IS_DELETED"};
        for (String col: cols){
            table.addCell(col,cellStyle);
        }
        userService.getAllUsers().forEach(e->{
            table.addCell(e.getUuid(),cellStyle);
            table.addCell(e.getName(),cellStyle);
            table.addCell(e.getEmail(),cellStyle);
            table.addCell(e.getCretedDate().toString(),cellStyle);
            table.addCell(e.getIsDeleted().toString(),cellStyle);
        });
        System.out.println(table.render());
    }
    public void deleteUserByUUID(){
        System.out.print("> User UUID: ");
        String uuid = new Scanner(System.in).nextLine();
        System.out.println("Row affected: " + userService.deleteUserByUuid(uuid));
    }
}
