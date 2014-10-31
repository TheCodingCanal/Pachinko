import java.util.ArrayList;
import java.util.Scanner;


public class Pachinko {
	
	char[] slots;
	
	public void solve() {
		
		Scanner scan = new Scanner (System.in);
		ArrayList<String> list = new ArrayList<>();
		String str = scan.nextLine();
		while(!str.equals("#")) {
			list.add(str);
			str = scan.nextLine();
		}
		scan.close();
		
		for(String line: list) {
			slots = line.toCharArray();
			int sum = 0;
			for (int i = 0; i < slots.length; i++) {
				sum += percentageFinder(i);
			}
			System.out.println((int)(sum/slots.length));
		}
		
		
		
		
	}
	
	public int percentageFinder (int pos) {
		if (slots[pos] == '.')
			return 100;
		if (slots[pos] == '_') {
			return 0;
		}
		if (slots[pos] == '|') {
			int percent = 0;
			if (rollLeft(pos-1))
				percent += 50;
			if (rollRight(pos+1))
				percent += 50;
			return percent;
		}
		if (slots[pos] == '/') {
			if (rollLeft(pos-1))
				return 100;
			else
				return 0;
		}
		else {
			if (rollRight(pos+1))
				return 100;
			else
				return 0;
		}
			
	}
	
	public boolean rollLeft (int p) {
		if (p < 0)
			return true;
		if (slots[p] == '_' && rollLeft(p-1))
			return true;
		if (slots[p] == '.')
			return true;
		return false;
	}
	
	public boolean rollRight (int p) {
		if (p >= slots.length)
			return true;
		if (slots[p] == '_' && rollRight(p+1))
			return true;
		if (slots[p] == '.')
			return true;
		return false;
	}
	
	
	public static void main (String[] args) {
		Pachinko p = new Pachinko();
		p.solve();
	}
}
