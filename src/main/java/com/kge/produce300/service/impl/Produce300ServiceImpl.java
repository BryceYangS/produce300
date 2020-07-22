package com.kge.produce300.service.impl;

import com.kge.produce300.domain.entity.AdministrativeDong;
import com.kge.produce300.domain.repository.AdministrativeDongRepository;
import com.kge.produce300.service.Produce300Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("produce300Service")
public class Produce300ServiceImpl implements Produce300Service {

    @Autowired
    private AdministrativeDongRepository adminDongRepo;

    @Override
    public List<AdministrativeDong> retrieveAdministrativeDongs(String electionCode) throws Exception {

        return adminDongRepo.findByPropertiesElectionCode(electionCode);
    }
}
