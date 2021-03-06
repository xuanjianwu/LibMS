package info.liyc.dao.proxy;

import info.liyc.dao.PublisherDao;
import info.liyc.dao.impl.PublisherDaoImpl;
import info.liyc.dbc.DatabaseConnection;

import java.sql.ResultSet;
import java.util.Vector;

/**
 * Created by liyc on 17-4-26.
 */
public class PublisherDaoProxy implements PublisherDao{
    private DatabaseConnection dbc = null;
    private PublisherDao dao = null;

    public PublisherDaoProxy() throws Exception {
        try {
            this.dbc = new DatabaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dao = new PublisherDaoImpl(this.dbc.getConnection());
    }

    @Override
    public int getPublisherId(String publisher) {
        try {
            return this.dao.getPublisherId(publisher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 4;
    }

    @Override
    public ResultSet getPublisherByAll() {
        try {
            return this.dao.getPublisherByAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Vector<String> getPublisherByAllToString() {
        try {
            return this.dao.getPublisherByAllToString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


