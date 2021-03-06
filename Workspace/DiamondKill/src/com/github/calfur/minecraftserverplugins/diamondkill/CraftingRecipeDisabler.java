package com.github.calfur.minecraftserverplugins.diamondkill;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Recipe;

public class CraftingRecipeDisabler {
	private static Material[] disabledRecipes = { Material.ANVIL, Material.BEACON, Material.FIREWORK_ROCKET };
	public static void removeDisabledCraftingRecipes() {
		for(Material disabledRecipe : disabledRecipes){
			removeCraftingRecipe(disabledRecipe);
		}
	}
	private static void removeCraftingRecipe(Material material) {
		Iterator<Recipe> it = Bukkit.getServer().recipeIterator();
        Recipe recipe;
        while(it.hasNext())
        {
            recipe = it.next();
            if (recipe != null && recipe.getResult().getType() == material)
            {
                it.remove();
            }
        }
	}
}