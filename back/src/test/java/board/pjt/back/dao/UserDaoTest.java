package board.pjt.back.dao;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

@SpringBootTest
class UserDaoTest {
    Calendar cal;
    @Autowired
    private UserDao userDao;

    void initDate() {
        cal = Calendar.getInstance();
        cal.set(1999, Calendar.SEPTEMBER, 18);
    }

    @DisplayName("select user")
    @Test
    void selectTest() throws Exception {
//        UserDto userDto = userDao.select("test@naver.com");
//        assertEquals("test", userDto.getNickname());

    }


    @Disabled
    @DisplayName("selectAll Test")
    @Test
    void selectAllTest() throws Exception {
//        int size = userDao.selectAll().size();

    }

    @Disabled
    @DisplayName("delete test")
    @Test
    void deleteTest() {
//        assertEquals(1, userDao.deleteUser("eunhee@naver.com"));

    }

    @DisplayName("insert user")
    @Test
    void insertTest() throws Exception {
//        assertEquals(1, userDao.deleteUser("eunhee@naver.com"));
//
//        int size = userDao.selectAll().size();
//        assertEquals(1, size);
//
//        initDate();
//        UserDto userDto = new UserDto("eunhee@naver.com", "admin", "admin", "eunhee", cal.getTime());
//        userDao.insert(userDto);
//
//        UserDto user = userDao.select("eunhee@naver.com");
//        assertEquals(user.getNickname(), "admin");

    }

    @DisplayName("update user test")
    @Test
    void updateUserTest() {
//        assertEquals(1, userDao.deleteUser("eunhee@naver.com"));
//
//        initDate();
//        UserDto userDto = new UserDto("eunhee@naver.com", "admin", "admin", "eunhee", cal.getTime());
//        userDao.insert(userDto);
//
//        userDto.setPassword("updatePassword");
//        userDto.setNickname("updateNickname");
//
//        assertEquals(1, userDao.updateUser(userDto));
    }


}
