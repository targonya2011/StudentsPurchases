There is an XML Hibernate configuration file in the config folder.
Create a separate empty MySQL database to which I will connect in this project and with which I will work.
Connected the Hibernate library to my project.
I created @Entity classes for all tables and prescribed relationships between them in accordance with the scheme:
![image](https://user-images.githubusercontent.com/59205706/235639468-c2b43aa6-69b4-488b-9825-b6ff5577c9c3.png)

This means that a pair of student_id and course_id values is unique for each record. Such a pair will allow you to get all the students of the course by course_id or find all the courses of one student by student_id, and also link these ids with the data of the Students and Courses tables.
If we try to add another record student_id=3 and course_id=22, the database will not allow us to do this with a composite key, since such a pair already exists.

Such a bundle of student_id and course_id is unique, it is called a composite key.

One of the options for creating a composite key is to write a separate class in which the fields will contain the values of the fields included in the composite key, and this class will already be used as the main Entity key.
