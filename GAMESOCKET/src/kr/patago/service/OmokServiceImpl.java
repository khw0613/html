package kr.patago.service;

import java.util.List;

import kr.patago.dao.OmokDaoImpl;
import kr.patago.vo.OmokVO;

public class OmokServiceImpl implements IOmokService{

	
	
	// 사용할 DAO의 객체변수를 선언한다.
	private OmokDaoImpl dao;
	
	private static OmokServiceImpl service;
	
	private OmokServiceImpl() {
		dao = OmokDaoImpl.getInstance();  // Dao객체 생성
	}
	
	public static OmokServiceImpl getInstance() {
		if(service == null) {
			service = new OmokServiceImpl();
		}
		return service;
	}
		
		
		
		
	@Override
	public int insert(OmokVO vo) {
		return dao.insert(vo);
	}

	@Override
	public List<OmokVO> selectList() {
		return dao.selectList();
	}

}
