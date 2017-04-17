package ru.itis.main.storages;

import ru.itis.main.generators.IdGenerator;
import ru.itis.main.models.Auto;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by АЛИМ on 17.04.2017.
 */
public class AutoDataStorage {

    private String fileName;
    private IdGenerator idGenerator;

    public AutoDataStorage(String fileName, IdGenerator idGenerator) {
        this.fileName = fileName;
        this.idGenerator = idGenerator;
    }

    public int save(Auto auto) {
        try {
            auto.setId(idGenerator.generateId());
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,true));
            String autoDataAsString = auto.toString();
            bufferedWriter.write(autoDataAsString + "\n");
            bufferedWriter.close();
            return auto.getId();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }

        return -1;
    }
    public Auto find(int id) {
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));

            String currentAutoData = reader.readLine();

            while (currentAutoData != null) {
                String currentAutoDataAsArray[] =
                        currentAutoData.split(" ");

                int currentAutoId =
                        Integer.parseInt(currentAutoDataAsArray[0]);

                if (currentAutoId == id) {
                    Auto founded = new Auto(
                            currentAutoDataAsArray[1],
                            currentAutoDataAsArray[2],
                           Integer.parseInt(currentAutoDataAsArray[3]));
                    founded.setId(id);
                    reader.close();
                    return founded;
                }
                currentAutoData = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return null;
    }
    public List<Auto> findAll() {
        ArrayList<Auto> allAutos = new ArrayList<>();
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));
            String currentAutoData = reader.readLine();
            while (currentAutoData != null) {
                String currentAutoDataAsArray[] =
                        currentAutoData.split(" ");

                int currentAutoId =
                        Integer.parseInt(currentAutoDataAsArray[0]);

                Auto autoFound = new Auto(
                        currentAutoDataAsArray[1],
                        currentAutoDataAsArray[2],
                        Integer.parseInt(currentAutoDataAsArray[3]));
                autoFound.setId(currentAutoId);
                allAutos.add(autoFound);
                currentAutoData = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return allAutos;
    }



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

        flushFromBuffer(buffer);
    }
    public void update(Auto auto) {
        List<Auto> buffer = findAll();
        int idOfUpdatedAuto = auto.getId();
        for(int i =0;i<buffer.size();i++) {
            Auto currentAuto = buffer.get(i);
            if (currentAuto.getId()==idOfUpdatedAuto) {
                buffer.set(i, auto);
                return;
            }
        }
        flushFromBuffer(buffer);
    }
    private void flushFromBuffer(List<Auto> buffer) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(fileName));

            for (int i = 0; i < buffer.size(); i++) {
                writer.write(buffer.get(i).toString());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }

}
