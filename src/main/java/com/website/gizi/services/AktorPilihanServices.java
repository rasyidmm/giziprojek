package com.website.gizi.services;

import com.website.gizi.dao.AktorPilihanDao;
import com.website.gizi.model.AktorPilihan;
import com.website.gizi.repository.AktorPilihanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AktorPilihanServices implements AktorPilihanDao {
    @Autowired
    AktorPilihanRepository aktorPilihanRepository;
    @Override
    public List<AktorPilihan> getAllAktorPilihan() {
        List<AktorPilihan> apl =  new ArrayList<>();
        aktorPilihanRepository.findAll().forEach(apl::add);
        return apl;
    }

    @Override
    public AktorPilihan getAktorPilihanById(long id) {
        AktorPilihan ap = aktorPilihanRepository.findById(id).get();
        return ap;
    }

    @Override
    public void SaveOrUpdateAktorPilihan(AktorPilihan a) {
        aktorPilihanRepository.save(a);
    }

    @Override
    public void deleteAktorPilihanById(long id) {
        aktorPilihanRepository.deleteById(id);
    }

    @Override
    public void deleteAktorPilihan(AktorPilihan a) {
        aktorPilihanRepository.delete(a);
    }
}
