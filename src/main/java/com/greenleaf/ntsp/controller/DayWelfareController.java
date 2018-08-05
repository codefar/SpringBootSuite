package com.greenleaf.ntsp.controller;

import com.greenleaf.ntsp.repository.DayWelfareEntity;
import com.greenleaf.ntsp.repository.DayWelfareJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/daywelfare/")
public class DayWelfareController {

    @Autowired
    DayWelfareJpaDao dayWelfareJpaDao;

    @RequestMapping(value = "/get")
    public DayWelfareEntity getDayWelfare() {
        List<DayWelfareEntity> dayWelfareEntities = dayWelfareJpaDao.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return dayWelfareEntities.isEmpty() ? null : dayWelfareEntities.get(dayWelfareEntities.size() - 1);
    }

    @GetMapping("/list")
    public List<DayWelfareEntity> getAllDayWelfare() {
        return dayWelfareJpaDao.findAll();
    }
}
