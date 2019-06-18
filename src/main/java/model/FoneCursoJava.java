package model;


public class FoneCursoJava {

    private long id;
    private String number;
    private String type;
    private long userUID;

    public FoneCursoJava() {
    }

    public FoneCursoJava(final long id, final String number, final String type, final long userUID) {
        super();
        this.id = id;
        this.number = number;
        this.type = type;
        this.userUID = userUID;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public long getUserUID() {
        return userUID;
    }

    public void setUserUID(final long userUID) {
        this.userUID = userUID;
    }

}
