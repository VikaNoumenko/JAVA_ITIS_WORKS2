package ru.itis.models;

/**
 * 20.04.2017
 * Contract
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Contract {
    private int id;
    private String myFio;
    private String contragentFio;
    private String date;

    public Contract(int id, String myFio, String contragentFio, String date) {
        this.id = id;
        this.myFio = myFio;
        this.contragentFio = contragentFio;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMyFio() {
        return myFio;
    }

    public void setMyFio(String myFio) {
        this.myFio = myFio;
    }

    public String getContragentFio() {
        return contragentFio;
    }

    public void setContragentFio(String contragentFio) {
        this.contragentFio = contragentFio;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean equals(Object object) {
        if (object != null && object instanceof Contract) {
            Contract that = (Contract)object;
            return this.id == that.id &&
                    this.myFio.equals(that.myFio) &&
                    this.contragentFio.equals(that.contragentFio) &&
                    this.date.equals(that.date);
        } return false;
    }
}
