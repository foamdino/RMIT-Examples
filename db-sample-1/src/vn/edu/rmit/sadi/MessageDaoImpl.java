package vn.edu.rmit.sadi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * This class implements the methods in the interface via a special Spring class: JdbcTemplate
 * JdbcTemplate allows you to write SQL to access the db, without worrying about all the checked exceptions
 */
public class MessageDaoImpl implements MessageDao {

    final private Log log = LogFactory.getLog(Client.class);

    private JdbcTemplate jdbcTemplate;

    // this is idiomatic spring/best practice to configure jdbcTemplates
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<String> allMessages() {
        List<String> messages = jdbcTemplate.query("select message from messages", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(1);
            }
        });
        return messages;
    }

    @Override
    public void saveMessage(String m) {
        jdbcTemplate.update("insert into messages(message) values(?)", m);
        for(String msg : allMessages()) {
            log.info(msg);
        }
    }

    @Override
    public String mostRecentMessage() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
