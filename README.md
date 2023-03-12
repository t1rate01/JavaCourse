# JavaCourse - Spring Boot

[Shortcut to relevant part](https://github.com/t1rate01/JavaCourse/tree/main/projectdemo/src/main/java/com/courseproject/projectdemo "Shortcut to relevant part of the project")

This is a Spring boot Java project assignment for school course.

I am attempting to use different methods diversily in the code, 
some parts could be written in a more repetive way.

In a nutshell: 

Includes a base class "Course", from which course Classes like "JavaCourse" and "PythonCourse" inherit from.
Includes an interface "IActiveCourse" which is implemented also by "Course"-s child classes.
Includes a student class.

Includes a Service class "CourseService" which has all the operation functions used by the REST class.
"CourseService" initializes some courses in its constructor and also calls an initializing function
that generates some students and adds them in courses. 

Courses and students are stored and handled as Lists.

Most relevant commenting is found in "CourseService".
