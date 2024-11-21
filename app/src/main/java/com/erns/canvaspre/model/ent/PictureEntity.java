package com.erns.canvaspre.model.ent;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pictures")
public class PictureEntity {
    @PrimaryKey
    public int pictureId;
    public String title;
    public String author;
    public String description;
    public String link;
    public int roomId;
    public float x;
    public float y;
    public PictureEntity(){}
    public PictureEntity(int pictureId, String title, String author, String description, String link, int roomId, float x, float y) {
        this.pictureId = pictureId;
        this.title = title;
        this.author = author;
        this.description = description;
        this.link = link;
        this.roomId = roomId;
        this.x = x;
        this.y = y;
    }
}
