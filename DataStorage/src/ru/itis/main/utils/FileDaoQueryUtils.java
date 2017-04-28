package ru.itis.main.utils;

import ru.itis.main.mappers.RowMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 27.04.2017
 * FileDaoQueryUtils
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class FileDaoQueryUtils {

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
        return null;
    }

    // findByValue - поиск сущности, у которой в колонке с номером valueColumn
    // стоит значение value
    public <T> List<T> findByValue(String fileName, RowMapper<T> mapper,
                             int valueColumn,
                             Object value) {
        List<T> models = new ArrayList<T>();
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));
            String currentRow = reader.readLine();

            while (currentRow != null) {
                String currentRowAsArray[] = currentRow.split(" ");
                String rowValue = currentRowAsArray[valueColumn];
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
}
