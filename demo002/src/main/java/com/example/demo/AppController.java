package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AppController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    int a = 0;

    @RequestMapping("/putAMessageIntoTopic")
    public String putAMessageIntoTopic() throws Exception {
        if (1==1) throw new Exception("Test Exception");
        String topicName = "rjmtest3";
        String msg = "abcd";
        kafkaTemplate.send(topicName, msg);
        //kafkaTemplate.flush();
        return "OK - " + (Integer.toString(a++));
    }

    @RequestMapping("/a")
    public List<String> getEmployees()
    {
        List<String> employeesList = basicList();
        return employeesList.stream()
                .map(s -> (s + s))
                .filter(s -> (s.compareTo("BB") == 0))
                .collect(Collectors.toList());
    }
    @RequestMapping("/b")
    public String getEmployees2()
    {
        List<String> employeesList = basicList();
        return employeesList.stream()
                .map(s -> (s + s))
                .filter(s -> (s.compareTo("BB") != 0))
                .reduce("", (a,b) -> (a.concat(b)));
    }




    private List<String> basicList() {
        List<String> employeesList = new ArrayList<String>();
        employeesList.add("A");
        employeesList.add("B");
        employeesList.add("C");
        return employeesList;
    }
}
