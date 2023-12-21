/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AllOutils;

import Models.Produits;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 *
 * @author MEGATRON
 */
public class Oimage {

    public static String extension;
    public Image images;
    public File Sourcespath;
    public boolean isChange=false;

    public boolean isIsChange() {
        return isChange;
    }

    public void setIsChange(boolean isChange) {
        this.isChange = isChange;
    }
    
    
    public void choisirImage(AnchorPane pane, ImageView imageP, int h, int w) {
        FileChooser open = new FileChooser();
        open.getExtensionFilters().add(new ExtensionFilter("Images", "*.jpg"));
        File file = open.showOpenDialog(pane.getScene().getWindow());
        if (file != null) {

            Sourcespath = new File(file.getAbsolutePath());
            images = new Image(file.toURI().toString(), w, h, false, true);
            imageP.setImage(images);

            //String fileName = file.getName();
            extension = ".jpg";
            setIsChange(true);
            
            /**
             * int dotIndex = fileName.lastIndexOf("."); if (dotIndex > 0 &&
             * dotIndex < fileName.length() - 1) { if(extension==null){
             * extension=".jpg"; }else{ extension =
             * "."+fileName.substring(dotIndex + 1); }
             *
             * //System.out.println(stokerImage(extension));
             *
             * }
             *
             * }
             *
             */
        }
    }

    public String stokerImage(Produits produits) {
         if(this.isIsChange()==true){
              String name = UUID.randomUUID().toString();
        File destination = new File("./src/Assets/Images/" + name + ".jpg");

        try {
            Files.copy(Sourcespath.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println(extension);
        } catch (Exception e) {
            System.out.println(e);
        }

        return destination.toString();
         }else{
             return produits.getImage();
         }
       
    }

    public String getImage(String name) {
        return name;
    }

}
