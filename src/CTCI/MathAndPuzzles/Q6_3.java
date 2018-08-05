package CTCI.MathAndPuzzles;

public class Q6_3 {
	//-------------------------
	//| 1| 2| 3| 4| 5| 6| 7| 8|
	//-------------------------
	//| 9|10|11|12|13|14|15|16|
	//-------------------------
	//|17|18|19|20|21|22|23|24|
	//-------------------------
	//|25|26|27|28|29|30|31|32|
	//-------------------------
	//|33|34|35|36|37|38|39|40|
	//-------------------------
	//|41|42|43|44|45|46|47|48|
	//-------------------------
	//|49|50|51|52|53|54|55|56|
	//-------------------------
	//|57|58|59|60|61|62|63|64|
	//-------------------------
	
	
	//solution
	
	//method 1
	//make the board black and white
	//the two corner will be the same color
	//each dominal will take 1b+1w
	//now we have 30b and 32w
	//it is impossible
	
	//method 2
	//start from first row
	//no mater how you put the dominos
	//you have put one(+2n) vertical
	//this one will in odd position in row 2
	//then even position in row 3
	//then odd postion in row 8
	//position 1 of row 8 is cut off
	//that means you can place it in 3, 5, 7
	//will make a hole can not fill by domino
	
	
}
