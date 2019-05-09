package kr.patago.service;

import java.util.List;

import kr.patago.vo.OmokVO;

public interface IOmokService {
	public int insert(OmokVO vo);
	public List<OmokVO> selectList();
}
