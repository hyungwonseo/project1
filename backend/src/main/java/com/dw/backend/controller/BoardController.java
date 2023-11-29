package com.dw.backend.controller;

import com.dw.backend.dto.BaseResponse;
import com.dw.backend.dto.BoardDto;
import com.dw.backend.enumstatus.ResultCode;
import com.dw.backend.model.Board;
import com.dw.backend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000",
        methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class BoardController {
    private final BoardService boardService;
    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/api/board")
    public ResponseEntity<BaseResponse<Void>> createBoard(@RequestBody BoardDto boardDto) {
        return new ResponseEntity<BaseResponse<Void>>(
                new BaseResponse<Void>(ResultCode.SUCCESS.name(),
                        null,
                        boardService.createBoard(boardDto)),
                HttpStatus.CREATED);
    }

    @GetMapping("/api/board")
    public ResponseEntity<BaseResponse<List<Board>>> getAllBoard() {
        List<Board> boardList = boardService.getAllBoard();
        return new ResponseEntity<BaseResponse<List<Board>>>(
                new BaseResponse<List<Board>>(ResultCode.SUCCESS.name(),
                        boardList,
                        "게시글을 모두 다운로드 완료하였습니다"),
                HttpStatus.OK);
    }

    @DeleteMapping("/api/board/delete/{id}")
    public ResponseEntity<BaseResponse<Void>> deleteBoard(@PathVariable long id) {
        return new ResponseEntity<BaseResponse<Void>>(
                new BaseResponse<Void>(ResultCode.SUCCESS.name(),
                        null,
                        boardService.deleteBoard(id)),
                HttpStatus.OK);
    }

    @GetMapping("api/board/id")
    public ResponseEntity<BaseResponse<Void>> getTest(@RequestHeader("X-LoginID") String id) {
        return new ResponseEntity<BaseResponse<Void>>(
                new BaseResponse<Void>(ResultCode.SUCCESS.name(),
                        null,
                        id),
                HttpStatus.OK);
    }
}
