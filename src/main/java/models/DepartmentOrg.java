package models;

public class DepartmentOrg {


    private String name;
    private String description;
    private int numEmployees;
    private  int id;

    public DepartmentOrg(String name, String description, int numEmployees) {
        this.name = name;
        this.description = description;
        this.numEmployees = numEmployees;

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

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int i) {
        this.numEmployees = numEmployees;
    }
}
