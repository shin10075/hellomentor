package com.kh.hellomentor.board.model.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {
    private int replyId;
    private int postNo;
    private int userNo;
    private String rContent;
    private String isDeleted;
    private Date createDate;
}
