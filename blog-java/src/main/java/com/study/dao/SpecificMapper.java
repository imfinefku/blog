package com.study.dao;

import com.study.bean.specific.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface SpecificMapper {

    public int addTag(Tag tag);

    public int updateTag(Tag tag);

    public int deleteTag(@Param("id") String id);

    public List<Tag> getTagPage(Map dataMap);

    public List<Tag> getTagAll();

    public int getTagCount();

    public int deleteFriend(@Param("id") String id);

    public List<Friend> getFriendPage(Map dataMap);

    public int getFriendCount();

    public List<Friend> getFriendAll();
}