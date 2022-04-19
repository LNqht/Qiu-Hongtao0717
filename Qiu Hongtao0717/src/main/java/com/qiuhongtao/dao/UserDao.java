package com.qiuhongtao.dao;

import com.qiuhongtao.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {

        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update ..... where id=? - do yourself

        //TODO 5.1 - write update sql where id=?
        //TODO 5.2 - create prepared statement
        //TODO 5.3 - executeUpdate()
        //TODO 5.4 - return int
        String sql="update usertable set username="+"'"+user.getUsername()+"'"+","+"password="+"'"+user.getPassword()+"'"
                +","+"email="+"'"+user.getEmail()+"'"+","+"gender="+"'"+user.getGender()+"'"+","+"birthdate="+"'"+user.getBirthDate()+"'"
                +"where id="+user.getId();
        PreparedStatement st= con.prepareStatement(sql);
        st.executeUpdate();

        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //user for login
        //select --- where username=? and password=?--- i will show you now
        String sql="select id,username,password,email,gender,birthdate from usertable where username="+"'"+username+"'"+"and password="+"'"+password+"'";
        PreparedStatement st= con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            //get from rs and set into user model
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));

            //done
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        return null;
    }
}
