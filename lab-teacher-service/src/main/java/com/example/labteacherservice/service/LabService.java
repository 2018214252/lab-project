package com.example.labteacherservice.service;

import com.example.labteacherservice.entity.Lab;
import com.example.labteacherservice.mapper.LabMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class LabService {
    @Autowired
    private LabMapper labMapper;

    @Cacheable(value = "labs")
    public List<Lab> listLabs() {
        log.debug("labs");
        return labMapper.list();
    }

    @CacheEvict(value = "labs", allEntries = true)
    public List<Lab> insertLab(Lab lab) {
        labMapper.insert(lab);
        return labMapper.list();
    }

    @CacheEvict(value = "labs", allEntries = true)
    public List<Lab> updateLab(Lab lab) {
        labMapper.updateById(lab);
        return labMapper.list();
    }

    @CacheEvict(value = "labs", allEntries = true)
    public List<Lab> deleteLab(long id) {
        labMapper.remove(id);
        log.debug("{}",labMapper.list().size());
        return labMapper.list();
    }

    public Lab getLabById(long id) {
        return labMapper.getLab(id);
    }
}
