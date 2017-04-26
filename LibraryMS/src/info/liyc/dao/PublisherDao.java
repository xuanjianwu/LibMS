package info.liyc.dao;

import java.sql.ResultSet;


/**
 * Created by liyc on 17-4-26.
 */
public interface PublisherDao {
    int getPublisherId(String publisher) throws Exception;
    ResultSet getPublisherByAll() throws Exception;
}
