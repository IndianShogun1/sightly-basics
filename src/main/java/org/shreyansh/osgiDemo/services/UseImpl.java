package org.shreyansh.osgiDemo.services;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.scripting.sightly.pojo.Use;
import org.osgi.service.component.annotations.Reference;

import javax.script.Bindings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UseImpl implements Use {

    @Reference
    SomeOtherService someOtherService;
    SlingHttpServletRequest request = null;
    List<String> students = null;
    String message = null;
    int size;
    String hello;

    public String getHello() {
        return "hello";
    }

    @Override
    public void init(Bindings bindings) {
        request = (SlingHttpServletRequest) bindings.get("request");
//        String operation;
//        if(request != null) {
//            operation = request.getParameter("operation");
//            if(operation.equals("delete")) {
//
//            }
//        }
    }

    public String getMessage() {
        return message;
    }

    public List<String> getStudents() {
        List<Student> it = new ArrayList<>();
        it = someOtherService.getStudentList();
        for (Student i: it) {
            students.add(i.toString());
        }
        return students;
    }

    public int getSize() {
        List<Student> it = new ArrayList<>();
        it = someOtherService.getStudentList();
        if(it == null){
            return 0;
        }
        return it.size();
    }
}
