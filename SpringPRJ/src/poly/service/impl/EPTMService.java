package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.persistance.mongo.IEPTMMapper;
import poly.service.IEPTMService;

@Service("EPTMService")
public class EPTMService implements IEPTMService {

	@Resource(name = "EPTMMapper")
	private IEPTMMapper EPTMMapper;

	// 로그 파일 생성 및 로그 출력을 위한 log4j 프레임워크의 자바 객체
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public boolean createCollection() throws Exception {

		log.info(this.getClass().getName() + ".createCollection Start!");

		// 생성할 컬렉션명
		String colNm = "EmpathyTable";

		return EPTMMapper.createCollection(colNm);
	}

}

