package vn.edu.rmit.sadi;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

// tells spring to load the correct xml file for this test
// by default this will be ClassNameTest-context.xml, so for this class: MessageDaoTest-context.xml
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class MessageDaoTest {

    // this is an alternative to using explicit setters - should not be used all the time
    @Autowired
    private MessageDao dao;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private DbUtil dbUtil;

    @Before
    public void createDb() {
        dbUtil.createDb();
    }

    @Test
    public void testDaoConfigured() throws Exception {
        //if Spring is configuring this test correctly, dao cannot be null
        Assert.assertNotNull(dao);
    }

    @Test
    public void testAllMessages() throws Exception {
        // initially there should be no messages
        List<String> messages = dao.allMessages();
        Assert.assertTrue(messages.isEmpty());

        // now we add a message
        String msg = "test";

        // use JdbcTemplate to store the message
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("insert into messages(message) values(?)", msg);

        messages = dao.allMessages();
        Assert.assertNotNull(messages);
        Assert.assertEquals(messages.get(0), msg);
    }

    @Test
    public void testSaveMessage() throws Exception {
        String msg = "test";
        dao.saveMessage(msg);

        // use JdbcTemplate to store the message
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("select message from messages");
        Map<String, Object> row = rows.get(0);
        String data = (String)row.get("message");
        Assert.assertEquals(msg, data);
    }


}
