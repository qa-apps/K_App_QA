package helpers;

import com.github.javafaker.Faker;
import enums.Status;
import models.Category;
import models.Pet;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class TestObjectGenerator {
    public static String randomString(int length){
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
    public static Pet generateRandomPet(){
        Faker faker = new Faker();
        Random random = new Random();
        String[]photoUrls = {faker.internet().image(),faker.internet().image()};
        Pet pet = new Pet(faker.cat().name(),photoUrls);
        pet.setStatus(Status.pending);
        Category category = new Category(faker.cat().breed(),random.nextLong());
        pet.setCategory(category);
        return pet;
    }
}