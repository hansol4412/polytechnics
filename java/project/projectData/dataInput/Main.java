package dataInput;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		RecipeBasic rb = new RecipeBasic();
		RecipeIngredient ri = new RecipeIngredient();
		RecipeProcess rp = new RecipeProcess();
		Scanner std = new Scanner(System.in);
		
		
		rb.fileReader();
		rb.listPrint();
		System.out.print("번호를 입력하세요:");
		int n = std.nextInt();
		String Recipenum = rb.findrecipe(n);	
		
		ri.fileReader();
		ri.printIngredient(Recipenum);
		rp.fileReader();
		rp.printProcess(Recipenum);
		

	}

}
