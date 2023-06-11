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
}
