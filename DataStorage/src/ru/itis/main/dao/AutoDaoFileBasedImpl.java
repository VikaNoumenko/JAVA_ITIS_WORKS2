package ru.itis.main.dao;

import ru.itis.main.exceptions.UserNotFoundException;
import ru.itis.main.mappers.RowMapper;
import ru.itis.main.models.Auto;
import ru.itis.main.utils.FileDaoQueryTemplate;
import ru.itis.main.models.User;
import java.util.ArrayList;
import java.util.List;

/**
 * 27.04.2017
 * AutoDaoFileBasedImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
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
            String rowAsArray[] = row.split(" ");
            Auto found = new Auto(
                    Integer.parseInt(rowAsArray[0]),
                    String.valueOf(rowAsArray[1]),
                    String.valueOf(rowAsArray[2]),
                    Integer.parseInt(rowAsArray[3]),
                    Boolean.parseBoolean(rowAsArray[4]));
            return found;
        }
    };
    @Override
    public Auto find(int id) {

        List<Auto> autos =  template.findByValue(fileName,
                autoRowMapper, 0, id);

        if (autos.size() == 0) {
            throw new UserNotFoundException("Auto with ID " + id + "is not found");
        } else {
            return autos.get(0);
        }
    }

    @Override
    public int save(Auto model) {
        return template.save(fileName, model);
    }

    @Override
    public void delete(int id) { template.deleteByValue(fileName, 0, id); }

    @Override
    public void update(Auto model) { template.update(fileName, model); }

    @Override
    public List<Auto> findAll() {
        return template.findAll(fileName, autoRowMapper);
    }

    @Override
    public List<Auto> findAllByUsed(boolean isUsed) {
        List<Auto> usedAutos = new ArrayList<>();

        List<Auto> autos = template.findAll(fileName,autoRowMapper);
        for(int i = 0; i < autos.size(); i++ ){
            if(autos.get(i).isUsed()){
                usedAutos.add(autos.get(i));
            }
        }
        return usedAutos;
    }


    @Override
    public List<Auto> findAllAutoByUserId(int userId) {
        int userId = user.getId();
        List<Auto> autos = template.findByValue(fileName,autoRowMapper,4,userId);
        if(autos.size() > -1 )

            return autos;
        }
    }
}
