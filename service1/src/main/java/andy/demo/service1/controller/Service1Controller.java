package andy.demo.service1.controller;

import andy.demo.AbstractController;
import andy.demo.service1.client.Service0Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * 1.本服务自己提供了一个服务实现
 * 1.1 GET /echo/{message}
 * 2. 本服务封装调用了 service0 的两个实现
 * 2.1 GET /test/{sleep_seconds}
 * 2.2 GET /user
 * <p/>
 * Created by ZhangGuohua on 2017/9/29.
 */
@RestController
public class Service1Controller extends AbstractController {
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

    @Autowired
    Service0Client service0Client;

    @GetMapping("/user/{sleep_seconds}")
    public String user(@PathVariable int sleep_seconds) {
        return service0Client.user("LiSi", sleep_seconds);
    }

    @GetMapping("test")
    public String test() {
        Student studentName = new Student().setStudentName("ZhangSan's student 1");
        User someone = new User().setId(0).setName("ZhangSan").setStudent(studentName);

        System.out.println(someone.toString());
        return service0Client.test(someone);
    }


    @GetMapping("echo/{message}")
    String echo(@PathVariable String message) {
        try {
            return "echo:" + message + "-implemented by service 1 " + LocalDateTime.now();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
