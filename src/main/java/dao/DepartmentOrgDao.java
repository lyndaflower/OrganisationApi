package dao;

import models.DepartmentOrg;

public interface DepartmentOrgDao {

    //create
    void add(DepartmentOrg departmentOrg);
    void addDepartmentOrgToNews(DepartmentOrg department, News news);

    //read
    //List<DepartmentOrg> getAll();
    //  DepartmentOrg findById(int id);
    //    List<News> getAllNewsByDepartmentOrg(int departmentOrgId);

    //update
    void update(int id, String name, String description, int numberOfEmployees);

    //delete
    void deleteById(int id);
    void clearAll()
}
