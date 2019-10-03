package models;

import org.sql2o.Connection;
import java.util.List;

public class DepartmentOrg {


    private String name;
    private String description;
    private String numemployees;
    private  int id;

    public DepartmentOrg(String name, String description, String numemployees) {
        this.name = name;
        this.description = description;
        this.numemployees = numemployees;

    }

    public String getName() {
        return name;
    }

    public void setName(String finance) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String handle_finance_business) {
        this.description = description;
    }

    public String getNumemployees() {
        return numemployees;
    }

    public void setNumemployees(int i) {
        this.numemployees = numemployees;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void save(){
        String sql="INSERT INTO department(name,description,numemployees) VALUES (:name,:description, :numemployees)";
        try(Connection con = DB.sql2o.open()){
            this.id =(int) con.createQuery(sql, true)
                    .throwOnMappingFailure(false)
                    .addParameter("name", this.name)
                    .addParameter("description", this.description)
                    .addParameter("numemployees", this.numemployees)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<DepartmentOrg> all(){
        String sql = "SELECT * FROM department";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(DepartmentOrg.class);
        }
    }
    public static DepartmentOrg find (int id){
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM department where id=:id";
            DepartmentOrg departments = (DepartmentOrg) con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(DepartmentOrg.class);
            return departments;
        }
    }



}
