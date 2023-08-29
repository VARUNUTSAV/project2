package com.Varun.project2.model;

import com.mongodb.lang.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Book")
public class book {
    @NonNull
    private int id;
    private int copies;
    @NonNull
    private int authorId;
    private String genre;

    public book(){
    }
    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }
    public int getCopies(){ return copies; }
    public void setCopies(int copies){ this.copies = copies; }
    public int getAuthorId(){ return authorId; }
    public void setAuthorId(int authorId){ this.authorId = authorId; }
    public String getGenre(){ return genre; }
    public void setGenre(String genre){ this.genre = genre;}

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", copies='" + copies + '\'' +
                ", authorId=" + authorId + '\'' +
                ", genre=" + genre +
                '}';
    }

}
