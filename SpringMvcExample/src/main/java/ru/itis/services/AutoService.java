package ru.itis.services;

import ru.itis.models.Auto;

import java.util.List;

/**
 * 20.05.2017
 * AutoService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface AutoService {
    void addAuto(Auto auto);
    List<Auto> getAllAuto();
}
