package com.magaofei.qa.mapper;

import com.magaofei.qa.dao.RequestResponseLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RequestResponseLogMapper {

    @Select("SELECT * FROM analysis_request_response_log WHERE id = #{id}")
    RequestResponseLog findById(@Param("id") Integer id);


}
