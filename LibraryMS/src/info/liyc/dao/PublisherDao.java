package info.liyc.dao;

import java.sql.ResultSet;
import java.util.Vector;


/**
 * Created by liyc on 17-4-26.
 */
public interface PublisherDao {
    int getPublisherId(String publisher);
    ResultSet getPublisherByAll();
    Vector<String> getPublisherByAllToString();
}
