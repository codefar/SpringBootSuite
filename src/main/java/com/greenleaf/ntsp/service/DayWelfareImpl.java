package com.greenleaf.ntsp.service;

import com.greenleaf.ntsp.repository.DayWelfareEntity;
import com.greenleaf.ntsp.repository.DayWelfareJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayWelfareImpl implements DayWelfare {

    @Autowired
    DayWelfareJpaDao dayWelfareJpaRepository;

    @Override
    public DayWelfareEntity getLast() {
        return dayWelfareJpaRepository.findById(0L).get();
    }
}
