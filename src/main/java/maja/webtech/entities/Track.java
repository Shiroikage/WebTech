package maja.webtech.entities;

import maja.webtech.DbEntry;

import java.util.Arrays;

public class Track {
    private String name;
    private String id;
    private String album; //maybe add album class?
    private String[] artists;
    private String trackHref;
    private Integer duration; //in ms
    private String imageHref;
    private String uri;

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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String[] getArtists() {
        return artists;
    }

    public void setArtists(String[] artists) {
        this.artists = artists;
    }

    public String getTrackHref() {
        return trackHref;
    }

    public void setTrackHref(String trackHref) {
        this.trackHref = trackHref;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getImageHref() {
        return imageHref;
    }

    public void setImageHref(String imageHref) {
        this.imageHref = imageHref;
    }

    public DbEntry createDbEntryFromTrack() {
        DbEntry dbEntry = new DbEntry();
        if(id != null) {
            dbEntry.setTrack_id(id);
        }
        if(name != null) {
            dbEntry.setName(name);
        }
        if(album != null) {
            dbEntry.setAlbum(album);
        }
        if(trackHref != null) {
            dbEntry.setSong_href(trackHref);
        }
        if(duration != null) {
            dbEntry.setDuration_ms(duration);
        }
        if(imageHref != null) {
            dbEntry.setImage_href(imageHref);
        }
        if(artists != null) {
            dbEntry.setArtists(Arrays.toString(artists));
        }
        if(uri != null) {
            dbEntry.setUri(uri);
        }
        return dbEntry;
    }
}
