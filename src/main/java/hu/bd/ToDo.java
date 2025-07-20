package hu.bd;

public class ToDo {
    private final String title;
    private final String description;

    public ToDo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return title + ";" + description;
    }

    public static ToDo fromString(String line) {
        String[] parts = line.split(";", 2);
        return new ToDo(parts[0], parts[1]);
    }
}
