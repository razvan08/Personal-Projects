package com.countries.consumeapi;

import com.countries.consumeapi.model.Person;
import com.countries.consumeapi.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {

    @Autowired
    private RestTemplate restTemplate;

    private static String url="https://api.agify.io/?name=razvan";

    /*@GetMapping("/countries")
    public List<Object> getCountries(){
        Object[] countries = restTemplate.getForObject(url,Object[].class);
        return Arrays.asList(countries);
    }*/

    /*@GetMapping("/currentprice")
    public String getCountries(){
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null,String.class);
        return responseEntity.getBody();
    }*/

    /*@GetMapping("/price")
    public String getPrice(){
        ResponseEntity<Price> responseEntity = restTemplate.exchange(url,HttpMethod.GET,null,Price.class);
        return responseEntity.getBody().getBpi().getEur().getCode();
    }*/

    @GetMapping("/me")
    public String getInfo(){
        ResponseEntity<String> responseEntity = restTemplate.exchange(url,HttpMethod.GET,null,String.class);
        return responseEntity.getBody();
    }

    @GetMapping("/me/getName")
    public String getName(){
        ResponseEntity<Person> responseEntity1 = restTemplate.exchange(url,HttpMethod.GET,null,Person.class);
        return responseEntity1.getBody().getName();
    }

    @GetMapping("/me/getAge")
    public int getAge(){
        ResponseEntity<Person> responseEntity2 = restTemplate.exchange(url,HttpMethod.GET,null,Person.class);
        return responseEntity2.getBody().getAge();
    }

    @GetMapping("/me/getCount")
    public int getCount(){
        ResponseEntity<Person> responseEntity4 = restTemplate.exchange(url,HttpMethod.GET,null,Person.class);
        return responseEntity4.getBody().getCount();
    }

    @PostMapping("/me/setName")
    public void setName(){
       ResponseEntity<Person> responseEntity3 = restTemplate.exchange(url,HttpMethod.POST,null,Person.class);
       responseEntity3.getBody().setName("Cristian");
    }
}
