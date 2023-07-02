package maja.webtech.entities;

import java.util.Arrays;
import java.util.Objects;

public class Playlist {
    //TODO: add addTrack() method -with Api call that adds it to playlist in Spotify?
    private String playlistId;
    private String playlistHref;
    private String name;
    private Track[] tracks;

    public Playlist(String playlistId, String name) {
        this.playlistId = playlistId;
        this.name = name;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistHref() {
        return playlistHref;
    }

    public void setPlaylistHref(String playlistHref) {
        this.playlistHref = playlistHref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Track[] getTracks() {
        return tracks;
    }

    public void setTracks(Track[] tracks) {
        this.tracks = tracks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Playlist playlist)) return false;
        return Objects.equals(playlistId, playlist.playlistId) && Objects.equals(playlistHref, playlist.playlistHref) && Objects.equals(name, playlist.name) && Arrays.equals(tracks, playlist.tracks);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(playlistId, playlistHref, name);
        result = 31 * result + Arrays.hashCode(tracks);
        return result;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistId='" + playlistId + '\'' +
                ", playlstHref='" + playlistHref + '\'' +
                ", name='" + name + '\'' +
                ", tracks=" + Arrays.toString(tracks) +
                '}';
    }

    public void addTrack() {

    }
}
