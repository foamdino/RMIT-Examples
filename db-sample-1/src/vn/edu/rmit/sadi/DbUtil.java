package vn.edu.rmit.sadi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import javax.sql.DataSource;

/**
 * This is only used to allow quick creation of a database
 */
public class DbUtil {

    private DataSource dataSource;

    private Log log = LogFactory.getLog(DbUtil.class);

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createDb() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        try {
            log.info("before query");
            String msg = jdbcTemplate.queryForObject("select message from messages limit 1", String.class);
            log.info("schema found: "+msg);
            log.info("after query");
        } catch(Exception e) {
            //no db present, so create the tables
            log.info("No tables found, creating db");
            Resource script = new ClassPathResource("vn/edu/rmit/sadi/createdb.sql");
            JdbcTestUtils.executeSqlScript(jdbcTemplate, script, true);
        }
    }
}
