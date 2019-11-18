package dao;

import java.util.List;

import vo.*;

public interface IAddressdao {
	public  abstract List<Province> getAllProvince()  throws Exception;
	public  abstract List<Province> getAllCity(String provCode)  throws Exception;
	public  abstract List<Province> getAllArea(String provCode)   throws Exception;
}
