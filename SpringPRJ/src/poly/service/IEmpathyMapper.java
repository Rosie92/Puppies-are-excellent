package poly.service;

import java.util.List;

import poly.dto.EmpathyDTO;

public interface IEmpathyMapper {

	/*
	 * MongoDB 컬렉션 생성
	 * 
	 * @param colNm 생성하는 컬렉션 이름
	 */
	
	public boolean creataCollection(String colNm) throws Exception;
	
	/*
	 * MongoDB 데이터 저장하기
	 * 
	 * @param pDTO 저장될 정보
	 */
	public int insertRank(List<EmpathyDTO> pList, String colNm) throws Exception;
}
