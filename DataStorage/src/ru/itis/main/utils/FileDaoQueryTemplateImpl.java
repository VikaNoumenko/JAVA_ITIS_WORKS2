package ru.itis.main.utils;

import ru.itis.main.generators.IdGenerator;
import ru.itis.main.mappers.RowMapper;
import ru.itis.main.models.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 27.04.2017
 * FileDaoQueryTemplateImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class FileDaoQueryTemplateImpl implements FileDaoQueryTemplate {

    private IdGenerator idGenerator;

    public FileDaoQueryTemplateImpl(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public <T> List<T> findAll(String fileName, RowMapper<T> mapper) {
        try {
            ArrayList<T> models = new ArrayList<>();
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));

            String currentRow = reader.readLine();

            while (currentRow != null) {
                T model = mapper.mapRow(currentRow);
                models.add(model);
                currentRow = reader.readLine();
            }
            return models;
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return new ArrayList<T>();
    }

    public <T> List<T> findByValue(String fileName, RowMapper<T> mapper,
                             int valueColumn,
                             Object value) {
        List<T> models = new ArrayList<T>();
        try {
            // открыли файл
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));
            // считали строку
            String currentRow = reader.readLine();

            while (currentRow != null) {
                // строку преобразовали в массив строк
                String currentRowAsArray[] = currentRow.split(" ");
                // забираем интересующее нас значение
                String rowValue = currentRowAsArray[valueColumn];
                // нужно для сравнения
                Object castedValue = null;
                if (value.getClass().getName().equals("java.lang.Integer")) {
                    castedValue = Integer.parseInt(rowValue);
                } else if (value.getClass().getName().equals("java.lang.Boolean")) {
                    castedValue = Boolean.parseBoolean(rowValue);
                } else if (value.getClass().getName().equals("java.lang.String")) {
                    castedValue = String.valueOf(rowValue);
                }

                if (value.equals(castedValue)) {
                    T model = mapper.mapRow(currentRow);
                    models.add(model);
                }

                currentRow = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return models;
    }

    @Override
    public <T> int save(String fileName, T model) {
        if (model instanceof Model) {
            Model castedModel = (Model) model;
            castedModel.setId(idGenerator.generateId());
            // преобразуем пользователя в строку через toString
            String userDataAsString = castedModel.toString();
            // открываем файловый поток для дозаписи
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                writer.write(userDataAsString);
                writer.newLine();
                writer.close();
                return castedModel.getId();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else throw new IllegalArgumentException("Model is not implement Model interface");
    }

    @Override
    public <T> void update(String fileName, T model) {
            int id = ((Model) model).getId();
            List<String> models = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String currentModel = reader.readLine();
                while(currentModel != null){
                    String currentModelAsArray[] = currentModel.split(" ");
                    int modelId = Integer.parseInt(currentModelAsArray[0]);
                    if(modelId == id){
                        models.add(model.toString());
                    }else{
                        models.add(currentModel);
                    }
                    currentModel = reader.readLine();
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    for(int i = 0; i < models.size(); i++){
                        writer.write(models.get(i));
                        writer.newLine();
                    }
                    writer.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("IO Exception");
            }

        }
    
    @Override
    public void deleteByValue(String fileName, int valueColumn, Object value) {
        try {
            List<String> models = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String current = reader.readLine();
            value = value.toString();
            int found = 0;
            while(current != null) {
                String currentAsArray[] = current.split(" ");
                String Element = currentAsArray[valueColumn];
                if(Element.equals(value)){
                    found++;
                }else{
                    models.add(current);
                }
                current = reader.readLine();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for(int i = 0; i < models.size(); i++){
                writer.write(models.get(i));
                writer.newLine();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }
}
