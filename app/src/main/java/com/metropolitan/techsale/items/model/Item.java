package com.metropolitan.techsale.items.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

// TODO info mora se doda da bi decodovalo json request na tacnu klasu
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Gpu.class, name = "gpu"),
        @JsonSubTypes.Type(value = Processor.class, name = "cpu"),
        @JsonSubTypes.Type(value = RamMemory.class, name = "ram"),
        @JsonSubTypes.Type(value = Storage.class, name = "storage")
})
public class Item {

    private int id;
    private String name;
    private String make;
    private double price;
    private int quantity;
    private String imageUrl;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Item() { }

    public Item(Item item){
        this.id = item.id;
        this.name = item.name;
        this.make = item.make;
        this.price = item.price;
        this.quantity = item.quantity;
        this.imageUrl = item.imageUrl;
    }

    public Item(int id, String name, String make, double price, int quantity, String imageUrl) {
        this.id = id;
        this.name = name;
        this.make = make;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", make='" + make + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", imageUrl='" + imageUrl + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
