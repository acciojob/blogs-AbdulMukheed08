package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image  = new Image(description,dimensions);

        Blog blog = blogRepository2.findById(blogId).get();

        blog.setImage(image);

        blogRepository2.save(blog);

        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        String[] screen = screenDimensions.split("X");
        int screenWidth = Integer.valueOf(screen[0]);
        int screenHeight = Integer.valueOf(screen[1]);

        Image image = imageRepository2.findById(id).get();
        String[] imageDimensions = image.getDimensions().split("X");
        int imageWidth = Integer.valueOf(imageDimensions[0]);
        int imageHeight = Integer.valueOf(imageDimensions[1]);

        int countOfImages = (screenWidth/imageWidth)*(screenHeight/imageHeight);

        return countOfImages;
    }
}
