package com.controller;


import com.dao.StudentDao;
import com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired //这意味着要获得名为userRepository的bean,它是Spring自动生成的，我们将使用它来处理数据
    private StudentDao studentDao;
    @PostMapping(path = "/add")
    public Student  addNewUser(@Param("name") String name, @Param("address") String address, @Param("age") int age){
        System.out.println(name);
        // @ResponseBody表示返回的String是响应，而不是视图名
        // @RequestParam表示它是来自GET或POST请求的参数
        Student student=new Student();
        student.setName(name);
        student.setAddress(address);
        student.setAge(age);
        Student save = studentDao.save(student);
        return save;

    }
    @GetMapping(path = "/findAll")
    public @ResponseBody Iterable<Student> findAllUser(){
        return studentDao.findAll();
    }

    @GetMapping("/t")
    public String t1(){
        return "dfggdfdfg";
    }

}
