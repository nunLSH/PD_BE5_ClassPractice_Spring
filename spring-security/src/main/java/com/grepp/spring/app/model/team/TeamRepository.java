package com.grepp.spring.app.model.team;

import com.grepp.spring.app.model.team.dto.TeamMember;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeamRepository {

    @Select("select * from team_member where USER_ID = #{id} and ACTIVATED")
    List<TeamMember> selectMembersByUserId(String id);

}