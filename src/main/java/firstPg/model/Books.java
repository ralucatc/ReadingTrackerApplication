package firstPg.model;

import javax.swing.*;
import java.util.ArrayList;

public class Books extends Object {

    private String author;
    private String title;
    private String publicationYear;
    private String description;
    private int progress;
    private ArrayList<String> reviews;

    public JButton getProg() {
        return Prog;
    }

    public void setProg(JButton prog) {
        Prog = prog;
    }

    private JButton Prog;

    public int getProgress() { return progress; }

    public void setProgress(int progress) { this.progress = progress; }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }
}
