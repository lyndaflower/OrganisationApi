package models;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        this.createdat = System.currentTimeMillis();
        setFormattedCreatedAt();
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

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    public long getCreatedat() {
        return createdat;
    }
    public void setCreatedat() {
        this.createdat = System.currentTimeMillis();

    }
    public String getFormattedCreatedAt(){
        Date date = new Date(createdat);
        String datePatternToUse = "MM/dd/yyyy @ K:mm a"; //see https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
        SimpleDateFormat sdf = new SimpleDateFormat(datePatternToUse);
        return sdf.format(date);
    }
    public void setFormattedCreatedAt(){
        Date date = new Date(this.createdat);
        String datePatternToUse = "MM/dd/yyyy @ K:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(datePatternToUse);
        this.formattedCreatedAt = sdf.format(date);
    }

}
