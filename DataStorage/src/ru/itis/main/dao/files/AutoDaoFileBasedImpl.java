package ru.itis.main.dao.files;

import ru.itis.main.dao.jdbc.AutoDao;
import ru.itis.main.exceptions.AutoNotFoundException;
import ru.itis.main.mappers.RowMapper;
import ru.itis.main.models.Auto;
import ru.itis.main.models.AutoBuilder;
import ru.itis.main.models.User;
import ru.itis.main.utils.FileDaoQueryTemplate;

import java.util.ArrayList;
import java.util.List;


public class AutoDaoFileBasedImpl implements AutoDao {
    private String fileName;
    private FileDaoQueryTemplate template;

    public AutoDaoFileBasedImpl(String fileName, FileDaoQueryTemplate template) {
        this.fileName = fileName;
        this.template = template;
    }

    private RowMapper<Auto> autoRowMapper = new RowMapper<Auto>() {
        @Override
        public Auto mapRow(String row) {
            String autoDataAsArray[] = row.split(" ");
            Auto auto = new Auto.Builder()
                    .id(Integer.parseInt(autoDataAsArray[0]))
                    .model(autoDataAsArray[1])
                    .color(autoDataAsArray[2])
                    .carMileage(Double.parseDouble(autoDataAsArray[3]))
                    .used(Boolean.parseBoolean(autoDataAsArray[4]))
                    .idOwner(Integer.parseInt(autoDataAsArray[5]))
                    .build();
            return auto;
        }
    };


    @Override
    public Auto find(int id) {
        List<Auto> autos = template.findByValue(fileName, autoRowMapper, 0, id);
        if (autos.size() == 0) {
            throw new AutoNotFoundException("Auto is not found");
        } else {
            return autos.get(0);
        }
    }

    @Override
    public int save(Auto auto) {
        return template.save(fileName, auto);
    }

    @Override
    public void delete(int id) {
        template.deleteByValue(fileName, 0, id);
    }

    @Override
    public void update(Auto auto) {
        template.update(fileName, auto);
    }

    @Override
    public List<Auto> findAll() {
        return template.findAll(fileName, autoRowMapper);
    }

    @Override
    public List<Auto> findAllByUsed() {
        List<Auto> autos = template.findAll(fileName, autoRowMapper);
        List<Auto> usedAutos = new ArrayList<>();
        for (int i = 0; i < autos.size(); i++) {

            if (autos.get(i).isUsed()) {
                usedAutos.add(autos.get(i));
            }
        }
        return usedAutos;
    }

    @Override
    public List<Auto> findAllAutoByOwner(User user) {
        int idUser = user.getId();
        List<Auto> autos = template.findByValue(fileName, autoRowMapper, 5, idUser);
        if (autos.size() > 0) {
            return autos;
        }
        throw new AutoNotFoundException("Auto is not found");
    }
}
