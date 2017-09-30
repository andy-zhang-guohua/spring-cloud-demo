package andy.demo.service0.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * 1.本服务自己提供了三个服务实现
 * 1.1 GET /echo/{message} // 能体现当前服务实现是哪个实例
 * 1.2 POST /test // RequestBody User JSON
 * 1.3 GET /user/{user_id}/{sleep_seconds}
 * <p/>
 * Created by ZhangGuohua on 2017/9/29.
 */
@RestController
public class Service0Controller {
    public static class User {
        private int id;
        private String name;

        private Student student;

        public User() {
        }

        public int getId() {
            return id;
        }

        public User setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public User setName(String name) {
            this.name = name;
            return this;
        }

        public Student getStudent() {
            return student;
        }

        public User setStudent(Student student) {
            this.student = student;
            return this;
        }

        @Override
        public String toString() {
            return "User{" + "id=" + id + ", name='" + name + '\'' + ", student=" + student + '}';
        }
    }

    public static class Student {
        private String studentName;

        public Student() {
        }

        public String getStudentName() {
            return studentName;
        }

        public Student setStudentName(String studentName) {
            this.studentName = studentName;
            return this;
        }

        @Override
        public String toString() {
            return "Student{" + "studentName='" + studentName + '\'' + '}';
        }
    }

    /**
     * 用于测试ribbon 重试机制
     */
    int count = 0;

    @GetMapping("user/{user_id}/{sleep_seconds}")
    String user(@PathVariable String user_id, @PathVariable int sleep_seconds) {
        try {
            System.out.println("hello:" + user_id);
            count++;
            TimeUnit.SECONDS.sleep(sleep_seconds - count);
            return "hello:" + user_id;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @PostMapping("test")
    String post(@RequestBody User user) {
        System.out.println(user.toString());
        return user.toString();
    }

    @GetMapping("echo/{message}")
    String echo(@PathVariable String message) {
        try {
            return "echo:" + message + "-implemented by service 0 " + LocalDateTime.now();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
