/**
 * Description : News_Heading.java is test file which is having test cases for News_Heading.
 * Author      : Tushar Chawat
 * Date        : 12/06/2021
 */

package com.bridgelabz.selenium;

import com.bridgelabz.selenium.Pages.News_Print;
import com.bridgelabz.selenium.base.Base;
import org.testng.annotations.Test;

public class NewsTest extends Base {
    public News_Print Print;

    @Test
    public void news_print(){
        Print = new News_Print(driver);
        Print.listOfNews();
        Print.MaximumWords();
        Print.maximumPointLines();
    }
}
