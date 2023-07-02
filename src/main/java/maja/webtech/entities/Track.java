package maja.webtech.entities;

public class Track {
    private String name;
    private String id;
    private String album; //maybe add album class?
    private String[] artists;
    private String trackHref;
    private Integer duration; //in ms
    private Integer popularity;

    public Track(String id) {
        this.id = id;
        //add track with id only, pull the other information from API
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
