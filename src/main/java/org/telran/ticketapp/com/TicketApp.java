package org.telran.ticketapp.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketApp {

    // localhost:8080/tickets -> DispatcherServlet(Controller) -> TicketController
    // localhost:8080/users -> DispatcherServlet(Controller) -> UserController
    public static void main(String[] args) {
        SpringApplication.run(TicketApp.class, args);
    }

//    ERROR   1
//    WARN    2
//    INFO    3
//    DEBUG   4
//    TRACE   5
//    ALL     6

//    StudentCourses
//    ID | name | course_id

//    JOIN select t1.name, t2.course_description from StudentCourses t1
//    left join Courses t2 on t2.id = t1.course_id

//    Courses
//    ID | course name | course description
}
