package com.example.recyclopedia;

/**
 * Created by Mariz on 12/9/2016.
 */
public class Game {
    private int game_id;
    private String game_item;
    private String game_itemtype;
    private String game_details;
    private String game_image;

    public Game() {

    }

    public Game(int game_id, String game_item, String game_itemtype, String game_details, String game_image) {
        this.game_id = game_id;
        this.game_item = game_item;
        this.game_itemtype = game_itemtype;
        this.game_details = game_details;
        this.game_image = game_image;
    }

    public void setGameID (int game_id) {
        this.game_id = game_id;
    }

    public void setGameItem (String game_item) {
        this.game_item = game_item;
    }

    public void setGameItemType (String game_itemtype) {
        this.game_itemtype = game_itemtype;
    }

    public void setGameDetails (String game_details) {
        this.game_details = game_details;
    }

    public void setGameImage (String game_image) {
        this.game_image = game_image;
    }

    public int getGameID () {
        return game_id;
    }

    public String getGameItem () {
        return game_item;
    }

    public String getGameItemType() {
        return game_itemtype;
    }

    public String getGameImage() {
        return game_image;
    }

}
