package com.seolandfriends.byeolbyeolcoffee.recipe.command.application.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import com.seolandfriends.byeolbyeolcoffee.recipe.command.domain.aggregate.vo.BaseBeverage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto implements Serializable {
	private Long recipeId;
	private String recipeName;
	private String photoUrl;
	private String description;
	private Long franchiseId;
	private BaseBeverage baseBeverage;
	private Long customOptionId;
	private String authorId;
	private LocalDateTime registerTime;
	private Integer likesCount;
	private Integer viewsCount;
}