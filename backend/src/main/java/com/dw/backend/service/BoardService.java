package com.dw.backend.service;

import com.dw.backend.dto.BaseResponse;
import com.dw.backend.dto.BoardDto;
import com.dw.backend.enumstatus.ResultCode;
import com.dw.backend.exception.InvalidIdException;
import com.dw.backend.model.Board;
import com.dw.backend.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public String createBoard(BoardDto boardDto) {
        // Board 객체 생성
        Board board = new Board(
                boardDto.getAuthor(),
                boardDto.getTitle(),
                boardDto.getText(),
                LocalDateTime.now()
        );
        // 리포지토리 저장
        boardRepository.save(board);
        return "게시글 생성이 완료되었습니다.";
    }

    public List<Board> getAllBoard() {
        return boardRepository.findAll();
    }

    public String deleteBoard(long id) {
        Optional<Board> board = boardRepository.findById(id);
        if (board.isEmpty()) {
            throw new InvalidIdException("board_id", "해당 게시글이 존재하지 않습니다");
        }
        boardRepository.deleteById(id);
        return "게시글 삭제가 완료되었습니다";
    }
}
