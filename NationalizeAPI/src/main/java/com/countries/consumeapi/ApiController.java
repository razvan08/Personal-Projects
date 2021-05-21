package com.countries.consumeapi;
import com.countries.consumeapi.model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiController {

    @Autowired
     private RestTemplate restTemplate;

    @GetMapping("/index/me")
    public String getInfo(@RequestParam(value = "name") String name){
       String url = "https://api.nationalize.io/?name="+name;
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null,String.class);
        return responseEntity.getBody();
    }

    @GetMapping("/index")
    public String Index(){

        return "<h1 style='text-align:center'> Doresti sa aflii nationalitatea ta in functie de nume? </h1>" +
                "<h2 style='text-align:center'> Introdu numele pentru a afla </h2>" + "<br> <br>"+
                "<input id='inp' type='text' style='margin-left:800px' >"+
                "<a id='submit' href='http://localhost:8080/index/me?name=razvan' >Submit name</a>";
    }

}
