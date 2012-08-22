package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.forms.FavoriteTimeSheetForm;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FavoriteTimeSheetTest {

    @Test
    public void shouldCreateNewFavoriteTimeSheet() throws Exception {
        //Given
        String favoriteName = "My Amazing Favorite TimeSheet";
        FavoriteTimeSheetForm favoriteTimeSheetForm = new FavoriteTimeSheetForm();
        favoriteTimeSheetForm.setName(favoriteName);

        //When
        FavoriteTimeSheetController favoriteTimeSheetController = new FavoriteTimeSheetController();
        ModelAndView result = favoriteTimeSheetController.doNewFavorite(favoriteTimeSheetForm);

        //Then
        assertThat((Boolean) result.getModel().get("success"), equalTo(true));
        assertThat((String) result.getModel().get("favoriteName"), equalTo(favoriteName));
    }

    @Test
    public void shouldShowErrorMessageWhenFavoriteNameIsEmpty() throws Exception {
        //Given
        String favoriteName = "";
        FavoriteTimeSheetForm favoriteTimeSheetForm = new FavoriteTimeSheetForm();
        favoriteTimeSheetForm.setName(favoriteName);

        //When
        FavoriteTimeSheetController favoriteTimeSheetController = new FavoriteTimeSheetController();
        ModelAndView result = favoriteTimeSheetController.doNewFavorite(favoriteTimeSheetForm);

        //Then
        assertThat((Boolean) result.getModel().get("success"), equalTo(false));
    }
}
