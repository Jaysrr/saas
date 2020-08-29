package com.saas.request;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-24 20:29
 **/
@Data
public class DeleteCommentsRequest {

    private Long id;

    private Long circleId;

    private Long userId;
}
