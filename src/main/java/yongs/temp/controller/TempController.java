package yongs.temp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yongs.temp.service.TempService;
import yongs.temp.vo.Temp;

@RestController
@RequestMapping("/")
public class TempController {
    private static final Logger logger = LoggerFactory.getLogger(TempController.class);	

    @Autowired
    TempService service;
 
    @GetMapping("/")
    public String home() throws Exception{
        return "home";
    }
    
    @GetMapping("/temps")
    public List<Temp> getTemps() throws Exception{
    	logger.debug("db-test|TempController|getTemps()"); 
        return service.getTemps();
    }
    
    @GetMapping("/temps/{id}")
    public Temp getTemp(@PathVariable("id") int id) throws Exception{
    	logger.debug("db-test|TempController|getTemp() ::: " + id); 
        return service.getTemp(id);
    }
    
    /* Postman 프로그램으로 실행 */
    @PostMapping("/temp")
    public void insertTemp(@RequestBody Temp tempVo) throws Exception{
    	logger.debug("db-test|TempController|insertTemp() ::: " + tempVo.getName());    	
   	   	service.insertTemp(tempVo);
    }
    /* Postman 프로그램으로 실행 */    
    @DeleteMapping("/temps/{id}")
    public void deleteTemp(@PathVariable("id") int id) throws Exception{
    	service.deleteTemp(id);
    }
}