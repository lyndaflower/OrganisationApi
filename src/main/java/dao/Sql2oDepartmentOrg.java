package dao;

import models.DepartmentOrg;
import models.New;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentOrg implements DepartmentOrgDao {
    private final Sql2o sql2o;
    public Sql2oDepartmentOrg(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(DepartmentOrg department) {
        String sql = "INSERT INTO department (name, description, numberOfEmployees) VALUES (:name, :description, :numberOfEmployees)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public void addDepartmentOrgToNews(DepartmentOrg department, New news) {

    }
    @Override
    public List<DepartmentOrg> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM department")
                    .executeAndFetch(DepartmentOrg.class);
        }
    }

    @Override
    public DepartmentOrg findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM department WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(DepartmentOrg.class);
        }
    }

    @Override
    public List<New> getAllNewsByDepartmentOrg(int departmentOrgId) {
        return null;
    }

    @Override
    public void update(int newId, String newName, String newDescription, int newNumEmployees) {
        String sql = "UPDATE department SET (name, description, numberOfEmployees) = (:name, :description, :numEmployees) WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", newId)
                    .addParameter("name", newName)
                    .addParameter("description", newDescription)
                    .addParameter("numEmployees", newNumEmployees)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from department WHERE id = :id";
        String deleteJoin = "DELETE from department_news WHERE departmentId = :departmentId";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            con.createQuery(deleteJoin)
                    .addParameter("departmentId", id)
                    .executeUpdate();

        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
    @Override
    public void clearAll() {
        String sql = "DELETE from department";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


//    @Override
//    public void addDepartmentToNews(DepartmentOrg department, New news){
//        String sql = "INSERT INTO department_news (departmentId, newsId) VALUES (:departmentId, :newsId)";
//        try (Connection con = sql2o.open()) {
//            con.createQuery(sql)
//                    .addParameter("departmentId", department.getId())
//                    .addParameter("newsId", news.getId())
//                    .executeUpdate();
//        } catch (Sql2oException ex){
//            System.out.println(ex);
//        }
//    }
//
//    @Override
//    public List<News> getAllNewsByDepartment(int departmentId){
//        List<News> news = new ArrayList(); //empty list
//        String joinQuery = "SELECT newsId FROM department_news WHERE departmentId = :departmentId";
//
//        try (Connection con = sql2o.open()) {
//            List<Integer> allNewsIds = con.createQuery(joinQuery)
//                    .addParameter("departmentId", departmentId)
//                    .executeAndFetch(Integer.class);
//            for (Integer foodId : allNewsIds){
//                String newsQuery = "SELECT * FROM news WHERE id = :newsId";
//                news.add(
//                        con.createQuery(newsQuery)
//                                .addParameter("newsId", foodId)
//                                .executeAndFetchFirst(News.class));
//            }
//        } catch (Sql2oException ex){
//            System.out.println(ex);
//        }
//        return news;
//    }


}
