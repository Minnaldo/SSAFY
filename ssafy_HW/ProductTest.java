package ssafy_HW;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV tv1 = new TV("QN82Q950RBFXKR", "QLED_8K_207cm", 16400000, 100, 81, "QLED");
		TV tv2 = new TV("QN43LS01RAFXKR", "The_Serif_108cm", 1640000, 150, 42, "QLED");
		TV tv3 = new TV("UN75RU7100F-S", "Premium_UHD_189cm", 3440000, 200, 74, "UHD");
		TV tv4 = new TV("QN49Q60RAF-S", "QLED_4K_123_cm", 1510000, 80, 48, "QLED");
		TV tv5 = new TV("UN65RU8100F-S", "Premium_UHD_163cm", 2810000, 120, 64, "UHD");
		
		Refrigerator rf1 = new Refrigerator("RF61R91C3AP", "BESPOKE", 3599000, 200, 870);
		Refrigerator rf2 = new Refrigerator("RF10R9990M1", "FAMILYHUB", 10100000, 300, 921);
		Refrigerator rf3 = new Refrigerator("RF61R91C335", "BESPOKE_Glam", 3599000, 150, 605);
		Refrigerator rf4 = new Refrigerator("RF10R9960M1", "CHEFCollection_Black", 8190000, 170, 928);
		Refrigerator rf5 = new Refrigerator("RF10R9945M5", "CHEFCollection_Brown", 7370000, 100, 949);
				
		TV[] tvArr = new TV[5];
		Refrigerator[] rfArr = new Refrigerator[5];
		
		tvArr[0] = tv1;
		tvArr[1] = tv2;
		tvArr[2] = tv3;
		tvArr[3] = tv4;
		tvArr[4] = tv5;
		
		rfArr[0] = rf1;
		rfArr[1] = rf2;
		rfArr[2] = rf3;
		rfArr[3] = rf4;
		rfArr[4] = rf5;
		
		System.out.println("=========================TV_Product=========================");
		for (int i = 0; i < tvArr.length; i++)
		{
			System.out.println(tvArr[i].toString());
		}
		
		System.out.println("=========================Refrigerator_Product=========================");
		for (int i = 0; i < rfArr.length; i++)
		{
			System.out.println(rfArr[i].toString());
		}
	}

}
