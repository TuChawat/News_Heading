/**
 * Description : News_Heading.java is test file which is having test cases for News_Heading.
 * Author      : Tushar Chawat
 * Date        : 12/06/2021
 */

package com.bridgelabz.selenium.Pages;

import com.bridgelabz.selenium.utility.Library;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.*;

public class News_Print {
    public static LinkedList<String> headlines = new LinkedList<>();
    public static LinkedList<Integer> points = new LinkedList<>();
    public static HashMap<String, Integer> Hashmap = new HashMap<>();
    public static HashMap<String, Integer> map = new HashMap<>();

    @FindBy(xpath = "//a[text() = 'More']")
    WebElement More;

    @FindBy(xpath = "//a[@class = 'storylink']")
    List<WebElement> Title;

    @FindBy(xpath = "//span[@class = 'score']")
    List<WebElement> Points;

    public News_Print(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void listOfNews() {
        int count = 30;
        while (count <= 120) {
            Iterator<WebElement> titleIterator = Title.iterator();
            while (titleIterator.hasNext()) {
                String news = titleIterator.next().getText();
                headlines.add(news);
            }
            Iterator<WebElement> pointIterator = Points.iterator();
            while (pointIterator.hasNext()) {
                String news = pointIterator.next().getText();
                String Itr = Library.getString(news);
                int intValue = Library.getValue(Itr);
                points.add(intValue);
            }
            More.click();
            count += 30;
        }
        for (int i = 0; i < points.size(); i++) {
                Hashmap.put(headlines.get(i), points.get(i));
        }
        for (Map.Entry<String, Integer> entry : Hashmap.entrySet()) {
            System.out.println("Headline :" + entry.getKey() + " Points :" + entry.getValue());
        }
    }

    public String MaximumWords() {
        String Itr = null;
        for (int i = 0; i < headlines.size(); i++) {
            String ItrArray[] = Library.getArray(headlines.get(i));
            for (int j = 0; j < ItrArray.length; j++) {
                if (map.get(ItrArray[j]) == null) {
                    map.put(ItrArray[j], 1);
                } else {
                    map.put(ItrArray[j], map.get(ItrArray[j]) + 1);
                }
            }
        }
        Integer[] intArray = map.values().toArray(new Integer[0]);
        Arrays.sort(intArray);
        int max = intArray[intArray.length - 1];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(max)) {
                Itr = entry.getKey();
                System.out.println("Maximum occured word is :" + entry.getKey() + " and value is : " + entry.getValue());
            }
        }
        return Itr;
    }

    public void maximumPointLines() {
        Integer[] intArray = Hashmap.values().toArray(new Integer[0]);
        Arrays.sort(intArray);
        int max = intArray[intArray.length - 1];
        for (Map.Entry<String, Integer> entry : Hashmap.entrySet()) {
            if (entry.getValue().equals(max)){
                System.out.println("News with maximum points :" +entry.getKey() + "and points are :" +entry.getValue());
            }
        }
    }
}
