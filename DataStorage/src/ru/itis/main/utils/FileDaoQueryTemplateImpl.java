package ru.itis.main.utils;

import ru.itis.main.generators.IdGenerator;
import ru.itis.main.mappers.RowMapper;
import ru.itis.main.models.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileDaoQueryTemplateImpl implements FileDaoQueryTemplate{
    IdGenerator idGenerator;

    public FileDaoQueryTemplateImpl(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public <T> List<T> findAll(String fileName, RowMapper<T> mapper) {
        try {
            ArrayList<T> models = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String currentModel = reader.readLine();
            while(currentModel != null){
                T model = mapper.mapRow(currentModel);
                models.add(model);
                currentModel = reader.readLine();
            }
            reader.close();
            return models;
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return new ArrayList<T>();
    }


    @Override
    public <T> int save(String fileName, T model) {
        if(model instanceof Model) {
            //Преобразуем нашу модель в интерфейс
            Model castedModel = (Model)model;
            castedModel.setId(idGenerator.generateId());
            String modelDataAsString = castedModel.toString();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                writer.write(modelDataAsString);
                writer.newLine();
                writer.close();
                return castedModel.getId();
            } catch (IOException e) {
                System.err.println("IO Exception");
            }
        }
        throw new IllegalArgumentException("Model is not implement Model interface");

    }

    @Override
    public <T> void update(String fileName,  T model) {
        if(model instanceof Model){
            int id = ((Model) model).getId();
            List<String> models = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String currentModel = reader.readLine();
                while(currentModel!=null){
                    String currentModelAsArray[] = currentModel.split(" ");
                    int modelId = Integer.parseInt(currentModelAsArray[0]);
                    if(modelId == id){
                        models.add(model.toString());
                    }else{
                        models.add(currentModel);
                    }
                    currentModel = reader.readLine();
                    // переписываем наш файл
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    for(int i = 0; i < models.size(); i++){
                        writer.write(models.get(i));
                        writer.newLine();
                    }
                    writer.close();
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found Exception!!!");
            } catch (IOException e) {
                System.err.println("IO Exception!!!");
            }

        }else{
            throw new IllegalArgumentException("This model is not implement Model interface!");
        }
    }

    @Override
    public <T> List<T> findByValue(String fileName, RowMapper<T> mapper, int valueColumn, Object value) {

        List<T> models = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String currentModelAsString = reader.readLine();
            while(currentModelAsString != null){
                Object castedValue = null;
                String currentModelAsArray[] = currentModelAsString.split(" ");
                String rowValue = currentModelAsArray[valueColumn];
                if(value.getClass().getName().equals("java.lang.String")){
                    castedValue = String.valueOf(rowValue);
                }else if(value.getClass().getName().equals("java.lang.Integer")){
                    castedValue = Integer.parseInt(rowValue);
                }else if(value.getClass().getName().equals("java.lang.Double")){
                    castedValue = Double.parseDouble(rowValue);
                }else if(value.getClass().getName().equals("java.lang.Boolean")){
                    castedValue = Boolean.valueOf(rowValue);
                }
                if(value.equals(castedValue)){
                    T model = mapper.mapRow(currentModelAsString);
                    models.add(model);
                }
                currentModelAsString = reader.readLine();

            }

            return models;
        } catch (FileNotFoundException e) {
            System.err.println("File not found Exception");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }

        return models;
    }
    @Override
    public void deleteByValue(String fileName, int valueColumn, Object value) {
        try {
            List<String> models = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String current = reader.readLine();
            value = value.toString();
            int finded = 0; // счетчик, что бы больше одного не удалить
            while(current!=null){
                String currenAsArray[] = current.split(" ");
                String needElement=currenAsArray[valueColumn];
                if(needElement.equals(value) && finded == 0){
                    finded++;
                }else{
                    models.add(current);
                }
                current = reader.readLine();
            }
            // переписываем наш файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for(int i = 0; i < models.size(); i++){
                writer.write(models.get(i));
                writer.newLine();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not Found Exception!!");
        } catch (IOException e) {
            System.err.println("IO Exception =(");
        }


    }
}