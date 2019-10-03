package models;

import org.sql2o.*;
public class DB {
    static String connectionString = "jdbc:postgresql://ec2-174-129-231-100.compute-1.amazonaws.com:5432/dcoos12vlkr3p8"; //!
    static Sql2o sql2o = new Sql2o(connectionString, "mabxxoavuzqtol", "f97e5b44751ab50ed780439af5f4512b938ec5d41c75f297ed785ce3dfe8a47f"); //!
}




