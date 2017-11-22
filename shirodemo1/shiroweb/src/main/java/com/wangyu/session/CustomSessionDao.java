package com.wangyu.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.jdbc.core.JdbcOperations;

import java.io.Serializable;
import java.util.Collection;

public class CustomSessionDao extends EnterpriseCacheSessionDAO {

    private JdbcOperations jdbcOperations;
//    private JdbcTemplate jdbcTemplate = JdbcTemplateUtils.jdbcTemplate();

    public CustomSessionDao() {
        jdbcOperations = SpringContextHelper.getBean(JdbcOperations.class);
//        jdbcOperations.update("CREATE TABLE DSESSION(ID INT PRIMARY KEY auto_increment, NAME VARCHAR(255));");
    }

    public Serializable doCreate(Session session) {
//        Serializable sessionId = this.generateSessionId(session);
//        this.assignSessionId(session, sessionId);
//        return sessionId;
        Serializable serializable = super.doCreate(session);
        System.out.println("SessionDAO:doCreate:" + session.getId());
//        jdbcOperations.update("INSERT INTO DSESSION (name) VALUES (?)", session.getId());
        return serializable;
    }

    protected Session doReadSession(Serializable sessionId) {
        System.out.println("SessionDAO:doReadSession:" + sessionId);
        SimpleSession session = new SimpleSession();
        session.setId(sessionId);
        return session;
    }

    protected void doUpdate(Session session) {
        System.out.println("SessionDAO:doUpdate:" + session.getId());
    }

    protected void doDelete(Session session) {
        System.out.println("SessionDAO:doDelete:" + session.getId());
    }

    @Override
    public Collection<Session> getActiveSessions() {
        return super.getActiveSessions();
    }
}
