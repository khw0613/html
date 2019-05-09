package kr.patago.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.patago.vo.OmokVO;

public class OmokDaoImpl implements IOmokDao {

	
	private SqlMapClient smc;
	private static OmokDaoImpl dao;
	public OmokDaoImpl() {
		// TODO Auto-generated constructor stub
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static OmokDaoImpl getInstance() {
		if(dao == null) {
			dao = new OmokDaoImpl();
		}
		
		return dao;	
	}
	
	
	
	@Override
	public int insert(OmokVO mv) {
		int cnt = 0;
		try {
			cnt = smc.update("omok.insert", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<OmokVO> selectList() {
		List<OmokVO> list = new ArrayList<OmokVO>();
		try {
			list = smc.queryForList("omok.selectlist");
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}	
		return list;
	}
	
	
}
