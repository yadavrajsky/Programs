class TypeConversion {

	public static void main(String[] args) {

		int a = 10;
		byte b = 10;
		byte c = 20;
		byte d = (byte) (b + c);
		int e = b + c;
		long f = 21474873648L;
		int x = (int) 21474873648L;
		// float y=(float)10.5;
		float y = 10.6F;
		// float z=10.5F;
		char i = (char) b;
		char u = (char) b;
		// byte b=(byte)a;
		// System.out.println(y+z);
		System.out.println(u);
		System.out.println(i);
	}
}
