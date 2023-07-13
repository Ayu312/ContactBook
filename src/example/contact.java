package example;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;

public class contact {
	public Scanner in;
	String name;
	String number;
	String mail;
	
	FileWriter fw = null;
	public contact() {
		in = new Scanner(System.in);
	}
	
	public void Choice() {
		System.out.println("どの作業をおこないますか？");
		System.out.println("1:追加 2:削除 3:表示");
		int a = in.nextInt();
		input(a);
		
	}
	
	public void addition() {
		in = new Scanner(System.in);
		
		System.out.println("情報を入力してください");
		System.out.println("名前:");
			name = in.nextLine();
		System.out.println("電話番号:");
			number = in.nextLine();
		System.out.println("メール:");
			mail = in.nextLine();

		try {
				FileWriter fw = new FileWriter("memo.csv", true);
		        PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

		            pw.print(name);
		            pw.print(",");
		            pw.print(number);
		            pw.print(",");
		            pw.print(mail);
		            pw.println();

		            pw.close();


		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
	}
	
	public void delete() {

		try {
			FileWriter fw = new FileWriter("memo.csv", false);
				fw.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	}
	
	public void display() {
		
		System.out.println("|   名前   |   電話番号   |     メール     |");
		
		 try (BufferedReader reader = new BufferedReader(new FileReader("memo.csv"))) {
	            String line;
	            
	            while ((line = reader.readLine()) != null) {
	                    String[] data = line.split(",");
	                        System.out.printf("%-11s",data[0]);
	                        System.out.printf("%-15s", data[1]);
	                        System.out.printf("%-17s\n",data[2]);	                    
	            }
	        } catch (IOException e) {
	            System.out.println("ファイル読み込みに失敗");
	        }
	}
	
	public void input(int num) {
		if(num == 1) {
			addition();
		} else if(num == 2) {
			delete();
		} else if (num == 3) {
			display();
		}
	}
	public int Continue() { //再度作業確認
		System.out.println("引き続き作業をおこないますか 1:はい 2:いいえ");
		int Set = in.nextInt();
		if(Set == 1) {
			return 0;
		} else if (Set == 2){
		}
		return 1;
	}
	
	public static void main(String[] args) {
		contact Con = new contact();
		while(true) {
			Con.Choice();
		if(Con.Continue() != 0) { 
			break;
		}
			
		}
	}

}
