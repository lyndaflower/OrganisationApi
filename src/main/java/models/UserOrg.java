package models;

import org.sql2o.*;

import java.util.List;

public class UserOrg {
    private String name;
    private  String role;
    private String position;
    private int departmentId;
    private int id;
    private long createdat;
    private String formattedCreatedAt;

    public UserOrg(String name, String role, String position, int departmentId){
        this.name = name;
        this.role = role;
        this.position =position;
        this.departmentId = departmentId;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String duties) {
        this.role = role;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public int getDepartmentId() {
        return departmentId;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void save(){
        String sql="INSERT INTO users(name,role,position,departmentid) VALUES (:name,:role,:position, :departmentId)";
        try(Connection con = DB.sql2o.open()){
            this.id =(int) con.createQuery(sql, true)
                    .throwOnMappingFailure(false)
                    .addParameter("name", this.name)
                    .addParameter("role", this.role)
                    .addParameter("position", this.position)
                    .addParameter("departmentId", this.departmentId)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static UserOrg find (int id){
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM users where id=:id";
            UserOrg users = (UserOrg) con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(UserOrg.class);
            return users;
        }
    }
    public static List<UserOrg> all(){
        String sql = "SELECT * FROM users";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(UserOrg.class);
        }
    }
}
