package kr.patago.dao;

import java.util.List;
import kr.patago.vo.OmokVO;

public interface IOmokDao {

	public int insert(OmokVO mv);
	public List<OmokVO> selectList();
	
}
