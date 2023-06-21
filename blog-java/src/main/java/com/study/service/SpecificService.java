package com.study.service;

import com.study.bean.specific.*;
import com.study.dao.SpecificMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SpecificService {

    @Autowired
    private SpecificMapper mapper;

    public int addTag(Tag tag) {
        return mapper.addTag(tag);
    }

    public int updateTag(Tag tag) {
        return mapper.updateTag(tag);
    }

    public int deleteTag(String id) {
        return mapper.deleteTag(id);
    }

    public List<Tag> getTagPage(Map dataMap) {
        return mapper.getTagPage(dataMap);
    }

    public List<Tag> getTagAll() {
        return mapper.getTagAll();
    }

    public int getTagCount() {
        return mapper.getTagCount();
    }

    public int deleteFriend(String id) {
        return mapper.deleteFriend(id);
    }

    public List<Friend> getFriendPage(Map dataMap) {
        return mapper.getFriendPage(dataMap);
    }

    public int getFriendCount() {
        return mapper.getFriendCount();
    }

    public List<Friend> getFriendAll(){
        return mapper.getFriendAll();
    }


}
