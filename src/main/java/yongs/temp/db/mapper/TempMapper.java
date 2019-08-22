package yongs.temp.db.mapper;

import java.util.List;

import yongs.temp.vo.Temp;

public interface TempMapper {
	public List<Temp> getTemps() throws Exception;
	public Temp getTemp(int id) throws Exception;
	public void insertTemp(Temp temp) throws Exception;
	public int deleteTemp(int id) throws Exception;
	public String getMaxId() throws Exception; 
}