package com.wangyu.session;

import com.wangyu.model.User;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CustomSessionDao extends EnterpriseCacheSessionDAO {

    @Autowired
    private JdbcOperations jdbcOperations;

    public CustomSessionDao() {
    }

    public Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        System.out.println("SessionDAO:doCreate:" + session.getId());
        jdbcOperations.update("INSERT INTO SESSION (ID, SESSION) VALUES (?, ?)", session.getId(), SerializableUtils.serialize(session));
        return sessionId;
    }

    protected Session doReadSession(Serializable sessionId) {
        System.out.println("SessionDAO:doReadSession:" + sessionId);
        List<String> list = jdbcOperations.queryForList("SELECT SESSION FROM SESSION WHERE ID = ?",
                new Serializable[]{sessionId}, String.class);
        if (list.size() > 0)
            return SerializableUtils.deserialize(list.get(0));
        else
            return null;
    }

    protected void doUpdate(Session session) {
        System.out.println("SessionDAO:doUpdate:" + session.getId());
        jdbcOperations.update("UPDATE SESSION SET SESSION = ? WHERE ID = ?", SerializableUtils.serialize(session), session.getId());
    }

    protected void doDelete(Session session) {
        System.out.println("SessionDAO:doDelete:" + session.getId());
        jdbcOperations.update("DELETE FROM SESSION WHERE ID = ?", session.getId());
    }

    @Override
    public Collection<Session> getActiveSessions() {
        System.out.println("SessionDAO:getActiveSessions");
        List<Session> list = jdbcOperations.query("SELECT SESSION FROM SESSION",
                new RowMapper(){
                    public Object mapRow(ResultSet rs, int no) throws SQLException {
                        return SerializableUtils.deserialize(rs.getString(1));
                    }
                });
        return list;
    }
}
