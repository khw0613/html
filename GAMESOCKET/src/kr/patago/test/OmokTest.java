package kr.patago.test;

import java.util.List;

import kr.patago.service.OmokServiceImpl;
import kr.patago.vo.OmokVO;

public class OmokTest {
	private OmokServiceImpl omokservice;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new OmokTest();
	}
	
	public OmokTest() {
		omokservice = OmokServiceImpl.getInstance();
		
		OmokVO vo = new OmokVO();
		vo.setPan("3");
		vo.setPan_order("1");
		vo.setHistory("1");
		vo.setWinner("1");
		

		omokservice.insert(vo);
		List<OmokVO> dd = omokservice.selectList();
		
		for(OmokVO gg : dd) {
			System.out.println(gg.getPan());
		}
		

	}

}
