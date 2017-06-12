package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dao.AutoDao;
import ru.itis.models.Auto;

import java.util.List;

/**
 * 20.05.2017
 * AutoServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoDao autoDao;

    @Override
    public void addAuto(Auto auto) {
        autoDao.save(auto);
    }

    @Override
    public List<Auto> getAllAuto() {
        return autoDao.findAll();
    }
}
