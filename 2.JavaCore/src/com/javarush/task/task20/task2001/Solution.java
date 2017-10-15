package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("data", null);
            OutputStream outputStream = new FileOutputStream("c:/data.txt");
            InputStream inputStream = new FileInputStream("c:/data.txt");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            //Human petrov = new Human("Ivanov");
            ivanov.save(outputStream);
            //petrov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
            //System.out.println(petrov.equals(somePerson));
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);

            String isNamePresent = name != null ? "yes" : "no";
            writer.println(isNamePresent);

            if (name!=null)
                writer.println(name);


            String isAssetsPresent = !assets.isEmpty() ? "yes" : "no";
            writer.println(isAssetsPresent);

            if (assets!=null){
                for (Asset a :assets) {
                    writer.print(a.getName() + " ");
                }
                writer.println();
            }


            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String isNamePresent = reader.readLine();
            if (isNamePresent.equals("yes")) {
                name = reader.readLine();
            }

            String isAssetsPresent = reader.readLine();
            if (isAssetsPresent.equals("yes")){
                String[] s = reader.readLine().split(" ");
                for (String string :s) {
                    assets.add(new Asset(string));
                }
            }
            reader.close();
        }
    }
}
