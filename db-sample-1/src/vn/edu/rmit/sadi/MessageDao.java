package vn.edu.rmit.sadi;

import java.util.List;

public interface MessageDao {

    List<String> allMessages();
    void saveMessage(String m);
    String mostRecentMessage();

}
