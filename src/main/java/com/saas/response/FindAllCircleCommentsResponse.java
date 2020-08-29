package com.saas.response;

import com.saas.dto.CommentsDto;
import lombok.Data;
import java.util.List;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 **/
@Data
public class FindAllCircleCommentsResponse {
    private List<CommentsDto> commentsDtoList;
    private Long total;

/*
    private PageInfo<CommentsDto> commentsPageInfo;
*/

}
