package dataInput;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{
		RecipeBasic rb = new RecipeBasic();
		RecipeIngredient ri = new RecipeIngredient();
		RecipeProcess rp = new RecipeProcess();
		
		rb.fileReader();
		//ri.fileReader();
		//rp.fileReader();
		

	}

}
