package maja.webtech;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;
//TODO: rework structure for project

@Entity
public class DbEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String track_id;
    private String name;
    private String album;
    private String artists;
    private int duration_ms;
    private String song_href;
    private String image_href; //640x640
    private int likes;
    private int dislikes;

    public DbEntry() {
    }

    public DbEntry(String track_id, String name) {
        this.track_id = track_id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getTrack_id() {
        return track_id;
    }

    public void setTrack_id(String id) {
        this.track_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public int getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(int duration_ms) {
        this.duration_ms = duration_ms;
    }

    public String getSong_href() {
        return song_href;
    }

    public void setSong_href(String song_href) {
        this.song_href = song_href;
    }

    public String getImage_href() {
        return image_href;
    }

    public void setImage_href(String image_href) {
        this.image_href = image_href;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DbEntry dbEntry)) return false;
        return duration_ms == dbEntry.duration_ms && likes == dbEntry.likes && dislikes == dbEntry.dislikes && Objects.equals(id, dbEntry.id) && Objects.equals(track_id, dbEntry.track_id) && Objects.equals(name, dbEntry.name) && Objects.equals(album, dbEntry.album) && Objects.equals(artists, dbEntry.artists) && Objects.equals(song_href, dbEntry.song_href) && Objects.equals(image_href, dbEntry.image_href);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, track_id, name, album, artists, duration_ms, song_href, image_href, likes, dislikes);
    }

    @Override
    public String toString() {
        return "DbEntry{" +
                "id=" + id +
                ", track_id='" + track_id + '\'' +
                ", name='" + name + '\'' +
                ", album='" + album + '\'' +
                ", artists='" + artists + '\'' +
                ", duration_ms=" + duration_ms +
                ", song_href='" + song_href + '\'' +
                ", image_href='" + image_href + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                '}';
    }
}