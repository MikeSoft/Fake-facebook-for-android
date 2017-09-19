package rootingtheai.mikeolivera.facebook.Database;

/**
 * Created by mikes on 19-Sep.
 */

public class SQL_STATEMENTS {




    static String create_database = "CREATE TABLE accounts ( id INTEGER PRIMARY KEY AUTOINCREMENT   NOT NULL , user VARCHAR(64) NOT NULL , password VARCHAR(64) NOT NULL , date VARCHAR(64) NOT NULL );";
    static String add_reg = "insert into accounts(user,password,date) values (?,?,?)";
    static String get_reg = "select * from accounts";



    static String t_accounts="accounts",a_user = "user", a_pass= "password",a_date="date";


    /*
    CREATE TABLE accounts (
	id INTEGER PRIMARY KEY AUTOINCREMENT   NOT NULL ,
	user VARCHAR(64) NOT NULL ,
	password VARCHAR(64) NOT NULL ,
	date VARCHAR(64) NOT NULL
);
     */
}
