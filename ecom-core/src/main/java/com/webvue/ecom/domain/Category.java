package com.webvue.ecom.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity<Long> {

   private static final long serialVersionUID = 1L;

   @NotEmpty
   @Size(min = 1, max = 20)
   private String            name;
   private String            description;

   @Lob
   private byte[]            photo;
   private String            photoName;

   @OneToMany(mappedBy = "category")
   private Collection<Item>  items;

   public Category() {
      super();
   }

   public Category(String name, String description, byte[] photo, String photoName) {
      super();
      this.name = name;
      this.description = description;
      this.photo = photo;
      this.photoName = photoName;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public byte[] getPhoto() {
      return photo;
   }

   public void setPhoto(byte[] photo) {
      this.photo = photo;
   }

   public String getPhotoName() {
      return photoName;
   }

   public void setPhotoName(String photoName) {
      this.photoName = photoName;
   }

   public Collection<Item> getItems() {
      return items;
   }

   public void setItems(Collection<Item> items) {
      this.items = items;
   }

}
