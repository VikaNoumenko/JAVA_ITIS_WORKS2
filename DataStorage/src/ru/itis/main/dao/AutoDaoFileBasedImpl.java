package ru.itis.main.dao;

import ru.itis.main.exceptions.AutoNotFoundException;
import ru.itis.main.generators.SingletonIdGenerator;
import ru.itis.main.mappers.RowMapper;
import ru.itis.main.models.Auto;
import ru.itis.main.utils.FileDaoQueryUtils;

import java.io.*;
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
    private FileDaoQueryUtils utils;

    public AutoDaoFileBasedImpl(String fileName) {
        this.fileName = fileName;
        this.utils = new FileDaoQueryUtils();
    }
    @Override
    public Auto find(int id) {
        List<Auto> autos =  utils.findByValue(fileName,
                autoRowMapper, 0, id);

        if (autos.size() == 0) {
            throw new AutoNotFoundException("ID of auto :" + id + "is not found");
        } else {
            return autos.get(0);
        }
    }

    @Override
    public int save(Auto auto) {
        try {
            auto.setId(SingletonIdGenerator.getGenerator().generateId());
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            String autoDataAsString = auto.toString();
            writer.write(autoDataAsString);
            writer.newLine();
            writer.close();
            return auto.getId();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }

        return -1;
    }
    private RowMapper<Auto> autoRowMapper = new RowMapper<Auto>() {
        @Override
        public Auto mapRow(String row) {
            String rowAsArray[] = row.split(" ");
            Auto founded = new Auto(
                    String.valueOf(rowAsArray[0]),
                    rowAsArray[1],
                    Integer.parseInt(rowAsArray[2]));
            return founded;
        }
    };
    @Override
    public void delete(int id) {
        List<Auto> buffer = findAll();
        int indexOfDeleted = -1;
        for (int i = 0; i < buffer.size(); i++) {
            Auto currentAuto = buffer.get(i);
            if (currentAuto.getId() == id) {
                indexOfDeleted = i;
                break;
            }
        }
        if (indexOfDeleted > -1) {
            buffer.remove(indexOfDeleted);
        }


    }

    @Override
    public void update(Auto model) {
        List<Auto> buffer = findAll();
        int idOfUpdatedAuto = model.getId();
        for(int i =0;i<buffer.size();i++) {
            Auto currentAuto = buffer.get(i);
            if (currentAuto.getId()==idOfUpdatedAuto) {
                buffer.set(i, model);
                return;
            }
        }

    }

    @Override
    public List<Auto> findAll() {
        return utils.findAll(fileName,autoRowMapper);
    }

    @Override
    public List<Auto> findAllByUsed(boolean isUsed) {
        List<Auto> usedAutos = new ArrayList<>();
        List<Auto> autos = utils.findAll(fileName,autoRowMapper);
//        for(int i = 0; i < autos.size(); i++ ) {
//            if (autos.get(i).isUsed()) {
//                usedAutos.add(autos.get(i));
//            }
//        }
//        return usedAutos;
    }


}
