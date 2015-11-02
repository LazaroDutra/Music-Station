
package music.station;

import java.util.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;



/**
 *
 * @author Lazaro
 */
public class Musica {
    
    private final SimpleStringProperty musica = new SimpleStringProperty();
    private final SimpleStringProperty album = new SimpleStringProperty();
    private final SimpleStringProperty artista = new SimpleStringProperty();
    private final SimpleStringProperty genero = new SimpleStringProperty();
    private final SimpleIntegerProperty clas = new SimpleIntegerProperty();
    private final ArrayList <Musica> cadmusicas;

    public Musica(String musica, String album, String artista, String genero, int clas) {
        this.musica.set(musica);
        this.album.set(album);
        this.artista.set(artista);
        this.genero.set(genero);
        this.clas.set(clas);
        cadmusicas = new ArrayList();
    }

    public String getMusica() {
        return musica.get();
    }

    public String getAlbum() {
        return album.get();
    }

    public String getArtista() {
        return artista.get();
    }

    public String getGenero() {
        return genero.get();
    }

    public int getClas() {
        return clas.get();
    }

    public void setMusica(String musica) {
        this.musica.set(musica);
    }

    public void setAlbum(String album) {
        this.album.set(album);
    }

    public void setArtista(String artista) {
        this.artista.set(artista);
    }

    public void setGenero(String genero) {
        this.genero.set(genero);
    }

    public void setClas(int clas) {
        this.clas.set(clas);
    }
    
    public void adM(Musica m){
        cadmusicas.add(m);
    }
    public void imprime(Musica m){
        System.out.println("Nome da Música: "+m.musica);
        System.out.println("Nome do Álbum: "+m.getAlbum());
        System.out.println("Nome do Artista: "+m.getArtista());
        System.out.println("Gênero da Música: "+m.getGenero());
        System.out.println("Classificação da Música: "+m.getClas());
        
    }
    

   
    
    
}
