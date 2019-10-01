package dao;

import models.DepartmentOrg;
import models.New;
import java.util.List;

public interface DepartmentOrgDao {

    //create
    void add(DepartmentOrg departmentOrg);
    void addDepartmentOrgToNews(DepartmentOrg department, New news);

    //read
    List<DepartmentOrg> getAll();
      DepartmentOrg findById(int id);
       List<New> getAllNewsByDepartmentOrg(int departmentOrgId);

    //update
    void update(int id, String name, String description, int numberOfEmployees);

    //delete
    void deleteById(int id);
    void clearAll();
}
