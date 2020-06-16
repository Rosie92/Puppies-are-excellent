package poly.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.BoardDTO;
import poly.persistance.mapper.BoardMapper;
import poly.service.IBoardService;

@Service("BoardService")
public class BoardService implements IBoardService {

	@Resource(name = "BoardMapper")
	private BoardMapper BoardMapper;

	@Override
	public int TotalCount() throws Exception {
		return BoardMapper.TotalCount();
	}
	

	@Override
	public List<BoardDTO> getBoardList (HashMap<String, Integer> hMap) throws Exception { 
		return BoardMapper.getBoardList(hMap); 
	}
	
	
	
	
	
	/*
	@Override
	public int BoardWrite(BoardDTO bDTO) throws Exception {
		return BoardMapper.BoardWrite(bDTO);
	}
	
	@Override
	public BoardDTO getBoardDetail(String seq) throws Exception {
		return BoardMapper.getBoardDetail(seq);
	}	
	
	@Override
	public BoardDTO BoardModifyCertify(BoardDTO pDTO) throws Exception {
			return BoardMapper.BoardModifyCertify(pDTO);
		}
	
	@Override
	public BoardDTO GUI2(BoardDTO pDTO) throws Exception {
		return BoardMapper.GUI2(pDTO);
	}

	@Override
	public BoardDTO BoardModifyCertify2(BoardDTO pDTO) throws Exception {
				return BoardMapper.BoardModifyCertify2(pDTO);
	}

	@Override
	public int BoardModify(BoardDTO pDTO) throws Exception {
		
		int res = 0;
		
		BoardDTO rDTO = BoardMapper.BoardModify(pDTO);
		
		if(rDTO == null) {
			rDTO = new BoardDTO();
		}
		if (CmmUtil.nvl(rDTO.getBoard_seq()).length()>0) {
			res = 1;
		}
		return res;
	}
	
	@Override
	public BoardDTO GUI3(BoardDTO pDTO) throws Exception {
		return BoardMapper.GUI3(pDTO);
	}
	
	
	
	@Override
	public int BoardUpdate(BoardDTO pDTO) throws Exception {
		return BoardMapper.BoardUpdate(pDTO);
	}
	

	@Override
	public int BoardDelete(BoardDTO pDTO) throws Exception {
		return BoardMapper.BoardDeleteBoard(pDTO);
	}
	
	
		
	@Override
	public BoardDTO GUI4(BoardDTO pDTO) throws Exception {
		return BoardMapper.GUI4(pDTO);
	}
	*/
	
	/*
	 * @Override public List<COMMENTDTO> readReply(String seq) throws Exception {
	 * return BMMapper.readReply(seq); }
	 * 
	 * @Override public List<COMMENTDTO> readReplySR(String seq) throws Exception {
	 * return BMMapper.readReplySR(seq); }
	 * 
	 * @Override public List<COMMENTDTO> readReplyQT(String seq) throws Exception {
	 * return BMMapper.readReplyQT(seq); }
	 * 
	 * @Override public List<COMMENTDTO> readReplyM(String seq) throws Exception {
	 * return BMMapper.readReplyM(seq); }
	 * 
	 * 
	 * @Override public int insertComment(COMMENTDTO bDTO) throws Exception { return
	 * BMMapper.insertComment(bDTO); }
	 * 
	 * @Override public int insertCommentSR(COMMENTDTO bDTO) throws Exception {
	 * return BMMapper.insertCommentSR(bDTO); }
	 * 
	 * @Override public int insertCommentQT(COMMENTDTO bDTO) throws Exception {
	 * return BMMapper.insertCommentQT(bDTO); }
	 * 
	 * @Override public int insertCommentM(COMMENTDTO bDTO) throws Exception {
	 * return BMMapper.insertCommentM(bDTO); }
	 * 
	 * 
	 * @Override public COMMENTDTO CommentModifyTry(COMMENTDTO pDTO) throws
	 * Exception { return BMMapper.CommentModifyTry(pDTO); }
	 * 
	 * @Override public COMMENTDTO CommentModifyTrySR(COMMENTDTO pDTO) throws
	 * Exception { return BMMapper.CommentModifyTrySR(pDTO); }
	 * 
	 * @Override public COMMENTDTO CommentModifyTryQT(COMMENTDTO pDTO) throws
	 * Exception { return BMMapper.CommentModifyTryQT(pDTO); }
	 * 
	 * @Override public COMMENTDTO CommentModifyTryM(COMMENTDTO pDTO) throws
	 * Exception { return BMMapper.CommentModifyTryM(pDTO); }
	 * 
	 * 
	 * @Override public int CommentCertify(COMMENTDTO pDTO) throws Exception {
	 * return BMMapper.CommentCertify(pDTO); }
	 * 
	 * @Override public int CommentCertifySR(COMMENTDTO pDTO) throws Exception {
	 * return BMMapper.CommentCertifySR(pDTO); }
	 * 
	 * @Override public int CommentCertifyQT(COMMENTDTO pDTO) throws Exception {
	 * return BMMapper.CommentCertifyQT(pDTO); }
	 * 
	 * @Override public int CommentCertifyM(COMMENTDTO pDTO) throws Exception {
	 * return BMMapper.CommentCertifyM(pDTO); }
	 * 
	 * 
	 * 
	 * @Override public COMMENTDTO CommentCertify2(COMMENTDTO pDTO) throws Exception
	 * { return BMMapper.CommentCertify2(pDTO); }
	 * 
	 * @Override public COMMENTDTO CommentCertify2SR(COMMENTDTO pDTO) throws
	 * Exception { return BMMapper.CommentCertify2SR(pDTO); }
	 * 
	 * @Override public COMMENTDTO CommentCertify2QT(COMMENTDTO pDTO) throws
	 * Exception { return BMMapper.CommentCertify2QT(pDTO); }
	 * 
	 * @Override public COMMENTDTO CommentCertify2M(COMMENTDTO pDTO) throws
	 * Exception { return BMMapper.CommentCertify2M(pDTO); }
	 * 
	 * 
	 * @Override public int CommentUpdate(COMMENTDTO pDTO) throws Exception { return
	 * BMMapper.CommentUpdate(pDTO); }
	 * 
	 * @Override public int CommentUpdateSR(COMMENTDTO pDTO) throws Exception {
	 * return BMMapper.CommentUpdateSR(pDTO); }
	 * 
	 * @Override public int CommentUpdateQT(COMMENTDTO pDTO) throws Exception {
	 * return BMMapper.CommentUpdateQT(pDTO); }
	 * 
	 * @Override public int CommentUpdateM(COMMENTDTO pDTO) throws Exception {
	 * return BMMapper.CommentUpdateM(pDTO); }
	 * 
	 * 
	 * @Override public int CommentDelete(COMMENTDTO pDTO) throws Exception { return
	 * BMMapper.CommentDelete(pDTO); }
	 * 
	 * @Override public int CommentDeleteSR(COMMENTDTO pDTO) throws Exception {
	 * return BMMapper.CommentDeleteSR(pDTO); }
	 * 
	 * @Override public int CommentDeleteQT(COMMENTDTO pDTO) throws Exception {
	 * return BMMapper.CommentDeleteQT(pDTO); }
	 * 
	 * @Override public int CommentDeleteM(COMMENTDTO pDTO) throws Exception {
	 * return BMMapper.CommentDeleteM(pDTO); }
	 * 
	 * 
	 * @Override public COMMENTDTO selectRe(COMMENTDTO pDTO) throws Exception {
	 * return BMMapper.selectRe(pDTO); }
	 * 
	 * @Override public COMMENTDTO selectReSR(COMMENTDTO pDTO) throws Exception {
	 * return BMMapper.selectReSR(pDTO); }
	 * 
	 * @Override public COMMENTDTO selectReQT(COMMENTDTO pDTO) throws Exception {
	 * return BMMapper.selectReQT(pDTO); }
	 * 
	 * @Override public COMMENTDTO selectReM(COMMENTDTO pDTO) throws Exception {
	 * return BMMapper.selectReM(pDTO); }
	 * 
	 * 
	 * 
	 * 
	 */	


}
