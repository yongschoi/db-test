package yongs.temp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yongs.temp.db.mapper.TempMapper;
import yongs.temp.vo.Temp;

@Service
public class TempService {
    private static final Logger logger = LoggerFactory.getLogger(TempService.class);	

    @Autowired
    TempMapper mapper;
    
    public List<Temp> getTemps() throws Exception {
        return mapper.getTemps();
    }
    
    public Temp getTemp(int id) throws Exception {
        return mapper.getTemp(id);
    }
    
    public void insertTemp(Temp temp) throws Exception {
    	String maxId = mapper.getMaxId();
    	if(maxId != null)
    		temp.setId(new Integer(new Integer(maxId) + 1).toString());
    	else
    		temp.setId("1");
    		
    	mapper.insertTemp(temp);
        logger.debug("신규 Temp ID ::: " + new Integer(temp.getId()).toString());
    }
    
    public void deleteTemp(int id) throws Exception {
        int deletedId = mapper.deleteTemp(id);
        logger.debug("삭제건수 ::: " + new Integer(deletedId).toString());
    }
}