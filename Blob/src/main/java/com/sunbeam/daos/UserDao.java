package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.sunbeam.pojos.User;
import com.sunbeam.utils.DbUtil;

public class UserDao implements AutoCloseable {
    private Connection con;
    public UserDao() throws Exception {
        con = DbUtil.getConnection();
    }
    @Override
    public void close() throws Exception {
        if(con != null)
            con.close();
    }
    public User findByEmail(String email) throws Exception {
        String sql = "SELECT * FROM user WHERE email=?";
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, email);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    email = rs.getString("email");
                    String password = rs.getString("password");
                    String phone = rs.getString("phone");
                    Timestamp created = rs.getTimestamp("created_on");
                    User u = new User(id, name, email, password, phone, created);
                    return u;
                }
            } // rs.close();
        } // stmt.close();
        return null;
    }
    public User findByEmailAndPassword(String email, String passwd) throws Exception {
        String sql = "SELECT * FROM user WHERE email=? AND password=?";
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, passwd);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    email = rs.getString("email");
                    String password = rs.getString("password");
                    String phone = rs.getString("phone");
                    Timestamp created = rs.getTimestamp("created_on");
                    User u = new User(id, name, email, password, phone, created);
                    return u;
                }
            } // rs.close();
        } // stmt.close();
        return null;
    }
    public int save(User u) throws Exception {
        String sql = "INSERT INTO user(full_name,email,password,phone_no,created_time) VALUES(?,?,?,?,NOW())";
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getPassword());
            stmt.setString(4, u.getPhone());
            
           int count = stmt.executeUpdate();
           System.out.println(sql);
           System.out.println(count);
           return count;
        } // stmt.close();
    }
}
