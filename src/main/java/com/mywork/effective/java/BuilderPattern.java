package com.mywork.effective.java;

/**
 * Class to demonstrate Builder Pattern
 */
public class BuilderPattern {
    public static void main(String[] args) {
        NutritionFacts2.Builder builder = new NutritionFacts2.Builder(23, 45);
        NutritionFacts2 nutritionFacts2 = builder.setCalories(34).setFat(45).build();
        System.out.println(nutritionFacts2.getSodium());
    }
}

final class NutritionFacts2
{
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    private NutritionFacts2(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public int getServingSize() {
        return servingSize;
    }

    public int getServings() {
        return servings;
    }

    public int getCalories() {
        return calories;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    static class Builder {
        private int servingSize;
        private int servings;
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;

        //mandatory parameter
        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder setCalories(int calories){
            this.calories = calories;
            return this;
        }

        public Builder setFat(int fat){
            this.fat = fat;
            return this;
        }

        public Builder setSodium(int sodium){
            this.sodium = sodium;
            return this;
        }

        public Builder setCarbohydrate(int carbohydrate){
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFacts2 build(){
            return new NutritionFacts2(servingSize, servings, calories, fat, sodium, carbohydrate);
        }

    }
}
